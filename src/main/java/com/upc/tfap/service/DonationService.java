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
		dr.delete(id);
		
	}

	@Override
	public Donation findOne(Long id) {
		// TODO Auto-generated method stub
		return dr.findOne(id);
	}

	@Override
	public <S extends Donation> S save(Donation d) {
		// TODO Auto-generated method stub
		return dr.save(d);
	}
	
	@Override
	public List<Donation>listarReal(Object u){
		return dr.findByUser((User)u);
	}
}
