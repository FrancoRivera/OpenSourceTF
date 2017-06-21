package com.upc.tfap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.upc.tfap.entity.Event;
import com.upc.tfap.entity.GatheringCenter;
import com.upc.tfap.entity.User;

public interface GatheringCenterRepository extends JpaRepository<GatheringCenter, Integer>{

	public List<GatheringCenter> findAll();
	
	public List<GatheringCenter> findByEvent(int id);
}
