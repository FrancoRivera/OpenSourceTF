package com.upc.tfap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.tfap.entity.Event;
import com.upc.tfap.entity.User;
import com.upc.tfap.repository.EventRepository;

@Service
public class EventService implements IEventService {
	
	@Autowired
	private EventRepository er;
	


	@Override
	public Iterable<Event> findAll(User user) {
		return er.findByUser(user);
	}

	@Override
	public void save(Event event) {
		System.out.println(event.getUser().getId());
		er.save(event); 
		
	}
	@Override
	public void delete(Integer id_event) {
		er.delete(id_event);
	}

	@Override
	public List<Event> findByNameEvent(String name_event) {
		// TODO Auto-generated method stub
		return er.findByNombre(name_event);
	}

	public Event findOne(Integer id) {
		// TODO Auto-generated method stub
		return er.findOne(id);
	}
	
	
	@Override
	public List<Event> listar() {	
		return er.findAll();
	}


	
}
