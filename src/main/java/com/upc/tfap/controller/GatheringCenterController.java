package com.upc.tfap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.tfap.entity.User;
import com.upc.tfap.entity.UsuarioAuth;
import com.upc.tfap.service.IEventService;
import com.upc.tfap.service.IGatheringCenterService;
import com.upc.tfap.util.Session;

@Controller
@PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
@RequestMapping("/gc")
public class GatheringCenterController {
	
	@Autowired
	private IGatheringCenterService ig; 
	
	@GetMapping(path={"/", ""})
	public String index(Model model){
		
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsuario());
		System.out.println("yolo1");
		model.addAttribute("lista", ig.findAll());
		System.out.println("yolo2");
		return "gcenter/listar_gcenter"; 
		
	}
	
	@GetMapping("/{id}")
	public String id(Model model, @PathVariable Integer e){
		System.out.println("sweg");
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsuario());
		model.addAttribute("lista", ig.findByEvent(e));
		System.out.println("sweag");
		return "gcenter/listar_gcenter"; 
		
	}
	
} 
