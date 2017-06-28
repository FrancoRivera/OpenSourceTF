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
		return gcr.findAll();
	}

	@Override
	public List<GatheringCenter> findByEvent(int id) {
		// TODO Auto-generated method stub
		Event evento = er.findOne(id);
		return gcr.findByEvent(evento);
	}

	
  
}
