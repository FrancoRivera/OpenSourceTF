package com.upc.tfap.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upc.tfap.entity.User;
import com.upc.tfap.service.IEventService;
import com.upc.tfap.service.IGatheringCenterService;
import com.upc.tfap.util.Session;

@Controller
@RequestMapping("/gatheringCenter")
public class GatheringCenterController {
	
	@Autowired
	private IGatheringCenterService ig; 
	
	
	@GetMapping("/{id}")
	public String index(Model model, HttpServletRequest request){
		if (auxiliar != null){
			model.addAttribute("gatheringCenter", ig.findByEvent(e));
			model.addAttribute("user", request.getSession().getAttribute("user"));
		}
		return "listar_gcenter"; 
		
	}
	
} 
