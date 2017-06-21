package com.upc.tfap.service;

import java.util.List;

import com.upc.tfap.entity.User;

public interface IUserService {
	public User login(User u);
	public List<User> listar();
	public String registrar(User U);
}
