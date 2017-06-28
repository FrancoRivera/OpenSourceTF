package com.upc.tfap.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.tfap.entity.Donation;
import com.upc.tfap.entity.GatheringCenter;
import com.upc.tfap.entity.User;
import com.upc.tfap.entity.UsuarioAuth;
import com.upc.tfap.service.IDonationService;
import com.upc.tfap.service.IGatheringCenterService;
import com.upc.tfap.service.IUserService;
import com.upc.tfap.util.Session;

@Controller
@PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
@RequestMapping("/donations")
public class DonationController {
	@Autowired
	IUserService ius;
	@Autowired
	IDonationService ids;
	@Autowired
	IGatheringCenterService igcs;

	
	@GetMapping(path={"/", ""})
	public String listDonation(Model model, HttpServletRequest request){
		
		//para obtener el usuario autenticado
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsuario());
		
		model.addAttribute("lista", ids.listarReal(user.getUsuario()));

		return "donaciones/listar_donacion";
	}
	
	
	//manejar si es nuevo ingreso o un editar, nose si este controlador funcione
	@GetMapping("/edit/{id}" )
	public String editDonacion(@PathVariable Long id,Model model){
		List<GatheringCenter> ls=new ArrayList<GatheringCenter>();
		ls.add(new GatheringCenter(1,"gc1"));
		ls.add(new GatheringCenter(9,"gc2"));
		if(id!=0){
			model.addAttribute("donation",ids.findOne(id));
		}else{
			Donation d=new Donation();
			model.addAttribute("donation",new Donation());
		}
		model.addAttribute("lista",igcs.findAll());
		return "donaciones/ingresa_donacion";
	}
	
	@PostMapping("/save")
	public String save(@Valid Donation donation,BindingResult result){
		if(result.hasErrors()){
			
			return "redirect:/donations/edit0";
		}
		
		donation.setDcreation(Date.valueOf(LocalDateTime.now().toLocalDate()));
		ids.save(donation);
		return "redirect:/donations";
	}
	@PostMapping("/delete")
	public String delete(HttpServletRequest request){
			
		Long id=Long.parseLong(request.getParameter("donation_id"));
		ids.delete(id);
		
		return "redirect:/donations";
	}
}
