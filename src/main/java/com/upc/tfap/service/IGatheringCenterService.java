package com.upc.tfap.service;

import java.util.List;

import com.upc.tfap.entity.Event;
import com.upc.tfap.entity.GatheringCenter;
import com.upc.tfap.entity.User;

public interface IGatheringCenterService {
	public List<GatheringCenter> findAll();
	
	public List<GatheringCenter> findByEvent(int id);
	
	public List<GatheringCenter> findByUser(User u);
	
	public void save(GatheringCenter gc);
	
	public void delete(GatheringCenter gc);
}
