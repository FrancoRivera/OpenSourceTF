package com.upc.tfap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="state")
public class Status {
	
	@Id
	private Integer id_state;
	
	@Column(name="name_state")
	private String name;
	
	public Integer getId() {
		return id_state;
	}

	public void setId(Integer id) {
		this.id_state = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name_state) {
		this.name = name_state;
	}


	
	
}
