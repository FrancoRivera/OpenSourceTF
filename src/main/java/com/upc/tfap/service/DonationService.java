package com.upc.tfap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.tfap.entity.Donation;
import com.upc.tfap.entity.User;
import com.upc.tfap.repository.DonationRepository;

@Service
public class DonationService implements IDonationService {

	@Autowired
	public DonationRepository dr;
	@Override
	public List<Donation> listar() {
		// TODO Auto-generated method stub
		return null; //dr.findAlljoin();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dr.deletes(id);
		
	}

	@Override
	public Donation findOne(Long id) {
		// TODO Auto-generated method stub
		return dr.findOne(id);
	}

	@Override
	public void save(Donation d) {
		// TODO Auto-generated method stub
		dr.save(d);
	}
	
	@Override
	public List<Donation>listarReal(User u){
		return dr.findByUser(u);
	}
}
