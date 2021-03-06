package com.upc.tfap.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public String login(Model model, 
			@RequestParam(name="error", required=false) String error, 
			@RequestParam(name="logout",required=false) String logout){
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return "usuario/login";
	}
	
	@GetMapping({"/loginsuccess","/"})
	public String loginCheck(Model model ){
		//Objeto User de Spring Security, metodo getPrincipal obtener el usuario principal de la sesion
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username", user.getUsername());
		return "redirect:/";
	}
	
}
