package com.upc.tfap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.upc.tfap.entity.Event;
import com.upc.tfap.entity.GatheringCenter;
import com.upc.tfap.entity.User;

public interface GatheringCenterRepository extends JpaRepository<GatheringCenter, Integer>{

	public List<GatheringCenter> findAll();
	
	public List<GatheringCenter> findByEvent(Event e);
	
	@Modifying
	@Query (value="UPDATE `Event` SET `id_state_gatheringcenter`='0' WHERE `id_gatheringcenter`=?1", nativeQuery=true)
	public void delete(Integer id);
	
	public List<GatheringCenter> findByUser(User u);
}
