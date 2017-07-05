package com.upc.tfap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "personrole")
public class RolUser {

	@Id
	@GeneratedValue
	private Long id_person_role;
    
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    private User usuario;

	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    private Rol role;

    
    public User getUsuario() {
		return usuario;
	}


	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}


	public Rol getRole() {
		return role;
	}


	public void setRole(Rol role) {
		this.role = role;
	}
}