package com.upc.tfap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.tfap.entity.User;

import antlr.debug.Event;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="call sp_loginUser(?1, ?2)", nativeQuery=true )
	public User login(String user, String password);

	public void delete(User u);
	
	public List<User> findAll();

	public User findByDniruc(String username); 
}