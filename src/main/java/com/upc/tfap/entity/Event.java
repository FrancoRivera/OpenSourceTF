package com.upc.tfap.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Event")
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_event;
	
	@ManyToOne
	@JoinColumn(name="id_Person_event")
	private User user;
	
	@Column(name="name_event")
	private String nombre;
	
	@Column(name="description_event")
	private String description;
	
	@Column(name="creation_date_event",  updatable = false)
	private Date creation_date = Date.valueOf(LocalDateTime.now().toLocalDate());
	
	@Column(name="starting_date_event")
	private Date starting_date;
	
	@Column(name="ending_date_event")
	private Date ending_date;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL) 
	@JoinColumn(name="id_state_event", updatable=false)
	private Status status;
	
	@OneToMany(mappedBy="event")
	List<GatheringCenter> gathering_centers;
	
	public List<GatheringCenter> getGathering_centers() {
		return gathering_centers;
	}
	public void setGathering_centers(List<GatheringCenter> gathering_centers) {
		this.gathering_centers = gathering_centers;
	}
	public int getId_event() {
		return id_event;
	}
	public void setId_event(int id_event) {
		this.id_event = id_event;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date cretion_date) {
		this.creation_date = cretion_date;
	}
	public Date getStarting_date() {
		return starting_date;
	}
	public void setStarting_date(Date starting_date) {
		this.starting_date = starting_date;
	}
	public Date getEnding_date() {
		return ending_date;
	}
	public void setEnding_date(Date ending_date) {
		this.ending_date = ending_date;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
