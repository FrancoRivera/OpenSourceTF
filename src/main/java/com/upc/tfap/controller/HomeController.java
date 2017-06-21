package com.upc.tfap.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upc.tfap.service.IEventService;
import com.upc.tfap.util.Session;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private IEventService ie; 
	
	
	@GetMapping("/")
	public String index(Model model, HttpServletRequest request){
		model.addAttribute("eventos", ie.listar());
		model.addAttribute("user", request.getSession().getAttribute("user"));
		return "home"; 
	}
	
	@GetMapping("/error")
	public String error(Model model){
		return "error"; 
	}
} 
