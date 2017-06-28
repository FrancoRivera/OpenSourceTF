package com.upc.tfap.service;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.tfap.entity.Event;
import com.upc.tfap.entity.GatheringCenter;
import com.upc.tfap.entity.User;
import com.upc.tfap.repository.EventRepository;
import com.upc.tfap.repository.GatheringCenterRepository;

@Service
public class GatheringCenterService implements IGatheringCenterService{

	
	@Autowired
	GatheringCenterRepository gcr;
	@Autowired
	EventRepository er;
	
	@Override
	public List<GatheringCenter> findAll() {
		// TODO Auto-generated method stub
		List<GatheringCenter> aux = new ArrayList<GatheringCenter>();
		List<GatheringCenter> lista = (List<GatheringCenter>) gcr.findAll();
		for (int i = 0; i < lista.size(); i++){
			if(!lista.get(i).getStatus().getName().contains("INA")){
				aux.add(lista.get(i));
				System.out.println(lista.get(i).getStatus().getName());
			}
		}
		return aux;

	}

	@Override
	public List<GatheringCenter> findByEvent(int id) {
		// TODO Auto-generated method stub
		Event evento = er.findOne(id);
		return gcr.findByEvent(evento);
	}

	@Override
	public List<GatheringCenter> findByUser(User u) {
		// TODO Auto-generated method stub
		return gcr.findByUser(u);
	}

	@Override
	public void save(GatheringCenter gc) {
		// TODO Auto-generated method stub
		gcr.save(gc);
		
	}

	@Override
	public void delete(GatheringCenter gc) {
		// TODO Auto-generated method stub
		gcr.delete(gc);
	}

	
  
}
