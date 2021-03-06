package com.upc.tfap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.upc.tfap.entity.Event;
import com.upc.tfap.entity.User;
import com.upc.tfap.entity.UsuarioAuth;
import com.upc.tfap.service.IEventService;
import com.upc.tfap.util.Session;

@Controller
@PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
@RequestMapping("/eventos")
public class EventController {
	
	@Autowired
	private IEventService es;
	
	@GetMapping(path={"/", ""})
	public String findAll(Model model, HttpServletRequest request){
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		model.addAttribute("user", user.getUsuario());
		System.out.println(user.getUsuario());
		model.addAttribute("eventos", es.findAll(user.getUsuario())); 

		
		return "eventos/listar_evento"; 
	}
	
	
	@GetMapping("/agregar")
	public String newEvent(Model model, HttpServletRequest request){
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		model.addAttribute("user", user.getUsuario());
		
		model.addAttribute("evento",new Event());
		
		return "eventos/ingresa_evento";
	
	}
	
	@PostMapping("/agregar")
	public String newEvent(Event e, Model model){
		es.save(e);
		return "redirect:/eventos";
	}

	@GetMapping("/{id}")
	public String findOne(@PathVariable Integer id,Model model){
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsuario());
		model.addAttribute("evento", es.findOne(id));
		
		
		return "eventos/ingresa_evento";
	}
	
	@PostMapping("/search")
	public String findByNameEvent(@RequestParam(name="texto") String texto,Model model){
		
		model.addAttribute("evento", es.findByNameEvent(texto));
		return "eventos/listar_evento";
	}
	
	@GetMapping("/update")
	public String updateUser(Model model){
		model.addAttribute("mensaje", "");
		model.addAttribute("lista", es.listar());
		return "eventos/listar_evento";
		
	}
	
	@GetMapping("/lista")
	public String listaUser(Model model){
		model.addAttribute("mensaje", "");
		model.addAttribute("eventos", new Event());
		return "eventos/listar_evento";  
		}
	
	@PostMapping("/{id}/delete")
	public String delete (@PathVariable Integer id,RedirectAttributes redirectAttrs)
	{
		es.delete(id);
		redirectAttrs.addFlashAttribute("Message","evento eliminado exitosamente");
		return "redirect:/eventos";
	}
	
}