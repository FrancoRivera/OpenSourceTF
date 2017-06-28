package com.upc.tfap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.upc.tfap.entity.Rol;
import com.upc.tfap.repository.UserRepository;

import com.upc.tfap.entity.User;
@Service
public interface IUserService extends UserDetailsService {
	public com.upc.tfap.entity.User login(com.upc.tfap.entity.User u);
	public List<com.upc.tfap.entity.User> listar();
	public String registrar(com.upc.tfap.entity.User u);
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	String delete(User u);
	
}