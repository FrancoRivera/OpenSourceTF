package com.upc.tfap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.tfap.entity.Event;
import com.upc.tfap.entity.GatheringCenter;
import com.upc.tfap.entity.User;
import com.upc.tfap.repository.EventRepository;

@Service
public class EventService implements IEventService {
	
	@Autowired
	private EventRepository er;
	


	@Override
	public Iterable<Event> findAll(User user) {
		List<Event> aux = new ArrayList<Event>();
		List<Event> lista = (List<Event>) er.findByUser(user);
		for (int i = 0; i < lista.size(); i++){
			if(!lista.get(i).getStatus().getName().contains("INA")){
				aux.add(lista.get(i));
				System.out.println(lista.get(i).getStatus().getName());
			}
		}
		return aux;

	}

	@Override
	public void save(Event event) {
		System.out.println(event);
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
		return null;
	}


	
}
