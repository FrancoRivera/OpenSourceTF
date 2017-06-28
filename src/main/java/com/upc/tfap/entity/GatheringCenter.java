package com.upc.tfap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="gatheringcenter")
public class GatheringCenter {
	@Id
	private int id_gatheringcenter;
	
	@Column(name="description_gatheringcenter")
	private String description;
	
	@Column(name="name_gatheringcenter")
	private	String nombre;
	
	@Column(name="img_gatheringcenter")
	private	String image;
	
	@ManyToOne
	@JoinColumn(name="id_state_gatheringcenter", insertable=false)
	private Status status; 

	@ManyToOne
	@JoinColumn(name="id_event_gatheringcenter")
	private Event event;
	
	@ManyToOne
	@JoinColumn(name="id_person_gatheringcenter")
	private User user;
	
	@OneToMany
	private List<Donation>donations;
	
	@Column(name="lattitude_gatherincenter")
	private double lattitude;
	
	@Column(name="longitude_gatherincenter")
	private double longitude;
	
	public GatheringCenter(int id_gatheringcenter, String nombre) {
		super();
		this.id_gatheringcenter = id_gatheringcenter;
		this.nombre = nombre;
	}
	public int getId_gatherincenter() {
		return id_gatheringcenter;
	}
	public void setId_gatherincenter(int id_gatherincenter) {
		this.id_gatheringcenter = id_gatherincenter;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getLattitude() {
		return lattitude;
	}
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}
	public double getLongitude() {
		return lattitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public GatheringCenter() {
		super();
	}
	public int getId_gatheringcenter() {
		return id_gatheringcenter;
	}
	public void setId_gatheringcenter(int id_gatheringcenter) {
		this.id_gatheringcenter = id_gatheringcenter;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Donation> getDonations() {
		return donations;
	}
	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
