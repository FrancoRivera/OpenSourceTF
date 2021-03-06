package com.upc.tfap.service;

import java.util.List;

import com.upc.tfap.entity.Event;
import com.upc.tfap.entity.User;

public interface IEventService {
	public Iterable<Event> listar();
	public Iterable<Event> findAll(User user);

	public void save(Event event);
	public void delete(Integer id_event);
	
	public List<Event> findByNameEvent(String name_event);
	
	public Event findOne(Integer id);


}
