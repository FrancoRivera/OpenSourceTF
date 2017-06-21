package com.upc.tfap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.upc.tfap.entity.User;

import antlr.debug.Event;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="call sp_loginUser(?1, ?2)", nativeQuery=true )
	public User login(String user, String password);
	
	public List<User> findAll(); 
}