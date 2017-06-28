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
	
	@Modifying
	@Query (value="UPDATE `Event` SET `id_state_person`='0' WHERE `id_person`=?1", nativeQuery=true)
	public void delete(Integer id);
	
	public List<User> findAll();

	public User findByDniruc(String username); 
}