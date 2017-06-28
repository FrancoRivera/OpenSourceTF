package com.upc.tfap.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upc.tfap.entity.UsuarioAuth;
import com.upc.tfap.service.IEventService;
import com.upc.tfap.util.Session;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private IEventService ie; 
	
	
	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("eventos", ie.listar());
		try{
			UsuarioAuth user=(UsuarioAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user.getUsuario());
			System.out.println(user.getAuthorities());
		}
		catch (Exception e) {
			// TODO: handle exception
		} 

		return "home"; 
	}
	
	@GetMapping("/error")
	public String error(Model model){
		return "error"; 
	}
} 
