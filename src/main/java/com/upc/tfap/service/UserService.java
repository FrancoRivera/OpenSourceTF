package com.upc.tfap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.tfap.entity.User;
import com.upc.tfap.repository.UserRepository;


@Service
public class UserService implements IUserService {

	@Autowired
	public UserRepository ue;
	
	@Override
	public User login(User u) {
		// TODO Auto-generated method stub
		return ue.login(u.getDniruc(), u.getPassword());
	}

	@Override
	public List<User> listar() {	
		return ue.findAll();
	}

	@Override
	public String registrar(User u) {
		if (ue.save(u) != null) return "Perfecto, ahora inicia sesion con tu nuevo usuario";
		return "Hubo un error, intenta nuevamente";
		
	}

}
