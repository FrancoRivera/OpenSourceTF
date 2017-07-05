package com.upc.tfap.entity;

import java.sql.Date;

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
import javax.persistence.criteria.Fetch;

import com.upc.tfap.entity.Status;

@Entity
public class Donation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_donation;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="id_donationtype_donation")
	private DonationType dt;
	

	@Column(name="description_donation")
	private String description;
	@Column(name="quantity_donation")
	private float quantity;
	@Column(name="creation_date_donation")
	
	private Date dcreation;
	
	@ManyToOne
	@JoinColumn(name="id_gatheringcenter_donation")
	private GatheringCenter gatheringcenter;
	
	




	//@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="id_state_donation",updatable=false, insertable=false)

	private Status status; 

	@ManyToOne/*(fetch=FetchType.EAGER, cascade=CascadeType.ALL)*/
	@JoinColumn(name="id_person_donation")
	private User user;
	
	public Donation(){
		gatheringcenter=new GatheringCenter();
		user= new User();
		quantity=0;
	}
	public Long getId_donation() {
		return id_donation;
	}
	public GatheringCenter getGatheringcenter() {
		return gatheringcenter;
	}
	public void setGatheringcenter(GatheringCenter gatheringcenter) {
		this.gatheringcenter = gatheringcenter;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setId_donation(Long id_donation) {
		this.id_donation = id_donation;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public Date getDcreation() {
		return dcreation;
	}
	public void setDcreation(Date dcreation) {
		this.dcreation = dcreation;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public DonationType getDt() {
		return dt;
	}
	public void setDt(DonationType dt) {
		this.dt = dt;
	}
	
}
