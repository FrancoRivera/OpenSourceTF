package com.upc.tfap.controller;


import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.tfap.entity.GatheringCenter;
import com.upc.tfap.entity.Status;
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
	
	@Autowired
	private IEventService ie;
	
	@GetMapping(path={"/", ""})
	public String index(Model model){
		
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsuario());
		model.addAttribute("lista", ig.findByUser(user.getUsuario()));

		return "gcenter/listar_gcenter"; 
		
	}
	
	@GetMapping("/{id[0-9+]}")
	public String id(Model model, @PathVariable Integer e){
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsuario());
		model.addAttribute("lista", ig.findByEvent(e));
		return "gcenter/listar_gcenter"; 
		
	}
	
	@GetMapping("/agregar")
	public String agregar(Model model){
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsuario());
		model.addAttribute("lista", ie.findAll(user.getUsuario()) );
		
		model.addAttribute("gcenter", new GatheringCenter());
		return "gcenter/ingresa_g_center"; 
		
	}
	
	@PostMapping("/agregar")
	public String agregarPost(Model model, GatheringCenter gc){
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsuario());
		gc.setUser(user.getUsuario());
		ig.save(gc);
		return "redirect:/gc"; 
		
	}
	
	@PostMapping("/eliminar")
	public String eliminarPost(Model model, GatheringCenter gc){
		UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsuario());
		ig.delete(gc);
		return "redirect:/gc"; 
		
	}
	
} 
