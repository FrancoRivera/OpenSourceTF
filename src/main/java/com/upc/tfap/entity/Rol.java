package com.upc.tfap.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Rol {

	@Id
	@GeneratedValue
	private Long id_role;
	
	


	private String name_role;
	
	
	public Rol() {

	}
	public Long getId_role() {
		return id_role;
	}


	public void setId_role(Long id_role) {
		this.id_role = id_role;
	}


	public String getName_role() {
		return name_role;
	}


	public void setName_role(String name_role) {
		this.name_role = name_role;
	}



}
