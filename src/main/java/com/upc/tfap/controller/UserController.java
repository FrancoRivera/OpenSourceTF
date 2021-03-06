package com.upc.tfap.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.upc.tfap.util.Session;
import com.upc.tfap.entity.User;
import com.upc.tfap.entity.UsuarioAuth;
import com.upc.tfap.service.IDonationService;
import com.upc.tfap.service.IUserService;

@Controller
@RequestMapping("/usuario")
public class UserController {
	
	@Autowired
	private IUserService iu; 
	@Autowired
	private IDonationService idon; 
	@GetMapping(path={"/",""})
	public String index(Model model){
		model.addAttribute("mensaje", "");
		model.addAttribute("user", new User());
		return "usuario/login";
	}


	@GetMapping("/registro")
	public String addUser(Model model){
		model.addAttribute("mensaje", "");
		model.addAttribute("user", new User());
		return "usuario/registrarme";  
	}
	
	@GetMapping("/update/{id}")
	public String updateUser(Model model,
			@RequestParam(name="id", required=false) String id){
		
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsuario());
		model.addAttribute("mensaje", "");
		return "usuario/registrarme";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(Model model,
			@RequestParam(name="id", required=false) String id){
		
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsuario());
		model.addAttribute("mensaje", "");
		return "usuario/registrarme";
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:/eventos"; 
	}
	
	@GetMapping("/lista")
	public String listaUser(Model model){
		model.addAttribute("mensaje", "");
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsuario());
		model.addAttribute("lista", iu.listar());
		return "usuario/listar_usuarios";  
	}

	@GetMapping("/profile/{id}")
	public String showUser(Model model,
			@RequestParam(name="id", required=false) String id){
		
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsuario());
		model.addAttribute("donaciones", idon.listarReal(user.getUsuario()));
		if (idon.listarReal(user.getUsuario()).size() == 0){
		 model.addAttribute("nivel", "Donador de nivel 0");
		}else if (idon.listarReal(user.getUsuario()).size() < 5){
			 model.addAttribute("nivel", "Donador de nivel 1");
		}else if (idon.listarReal(user.getUsuario()).size() < 10){
			 model.addAttribute("nivel", "Donador de nivel 2");
		}else if (idon.listarReal(user.getUsuario()).size() < 15){
			model.addAttribute("nivel", "Donador de nivel 3");
		}else if (idon.listarReal(user.getUsuario()).size() < 20){
				model.addAttribute("nivel", "Donador de nivel 4");
		}else{
				 model.addAttribute("nivel", "Donador de nivel 5");
			}
		model.addAttribute("mensaje", "");
		model.addAttribute("mensaje", "");
		return "usuario/profile";
	}
	@PostMapping(path={"/", ""})
	public String login(Model m, User u, HttpServletRequest request){
		if(iu.login(u) == null){
			m.addAttribute("mensaje", "Usuario y/o Contraseña incorrectos. Intenta nuevamente");
			return "redirect:/usuario/"; 
		}	
		else{
			
			Session.put(request, "user", iu.login(u));
			return "redirect:/eventos";
			}
		}
	
	
	
	@PostMapping("/registro")
	public ModelAndView registro(ModelMap m, User u){
		iu.registrar(u);
		m.addAttribute("mensaje", "Usuario y/o Contraseña incorrectos. Intenta nuevamente");
		return new ModelAndView("redirect:/usuario", m);  
	}
	
}
