package com.upc.tfap.service;

import java.util.List;

import com.upc.tfap.entity.Donation;
import com.upc.tfap.entity.User;

public interface IDonationService {
	public List<Donation> listar();
	public void delete(Long id);
	public Donation findOne(Long id);
	public void save(Donation d);
	
	public List<Donation>listarReal(User u);

	

}
