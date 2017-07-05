package com.upc.tfap.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.upc.tfap.entity.*;
public interface DonationTypeRepository extends JpaRepository<DonationType,Integer> {
	
}
