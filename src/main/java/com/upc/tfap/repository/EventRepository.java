package com.upc.tfap.repository;

import java.util.List;

import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.upc.tfap.entity.Event;
import com.upc.tfap.entity.User;

public interface EventRepository extends JpaRepository<Event, Integer>{
	 
	//@Query(value="call sp_list_Event_by_User(?1)", nativeQuery=true )
	public Iterable<Event> findByUser(User u); 

	//@Query ("select * from Event e where e.name_event like ?1")
	public List<Event> findByNombre(String name_event); 

	public Event findOne(Integer id);
	
	@Modifying
	@Query (value="UPDATE `Event` SET `estado_event`='INA' WHERE `id_event`=?1", nativeQuery=true)
	public void delete(Integer id);
	
	public List<Event> findAll(); 

	
}
