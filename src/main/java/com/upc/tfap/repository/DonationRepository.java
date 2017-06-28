package com.upc.tfap.repository;

import org.springframework.transaction.annotation.Transactional;

import com.upc.tfap.entity.Donation;
import com.upc.tfap.entity.User;

import java.util.List;

import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface DonationRepository extends JpaRepository<Donation, Long>{


	public List<Donation>findAll();
	
	@Modifying
	@Query(value = "delete from donation where id_donation = ?1", nativeQuery = true)
	public void delete(Long id);
	
	
	public Donation findOne(Long id);
	public <S extends Donation> S save(Donation d);
	
	public List<Donation> findByUser(User u);
}
