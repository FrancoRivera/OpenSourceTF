package com.upc.tfap.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upc.tfap.repository.DonationTypeRepository;
import com.upc.tfap.service.IDonationService;
import com.upc.tfap.service.IGatheringCenterService;
import com.upc.tfap.service.IUserService;

@Controller
@RequestMapping("/api/v1")
public class APIController {
	@Autowired
	IUserService ius;
	@Autowired
	IDonationService ids;
	@Autowired
	IGatheringCenterService igcs;
	@Autowired
	DonationTypeRepository dtrp;
	
	@GetMapping(path={"/", ""})
	public String listDonation(Model model, HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(igcs.findAll());
	}
	
	
}
	