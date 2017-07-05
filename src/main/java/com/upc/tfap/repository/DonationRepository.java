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
	@Query (value="UPDATE `Donation` SET `id_state_donation`='0' WHERE `id_donation`=?1", nativeQuery=true)
	public void deletes(Long id);
	
	
	public Donation findOne(Long id);
	@Query (value="select * from `Donation` WHERE `id_person_donation`=?1 AND `id_state_donation`=1", nativeQuery=true)
	public List<Donation> findByUser(User u);
}
