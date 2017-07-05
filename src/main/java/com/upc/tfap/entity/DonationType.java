package com.upc.tfap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="donationtype")
public class DonationType {
	@Id
	private int id_donationtype;
	
	@OneToMany(mappedBy="dt")
	private List<Donation>donations;
	
	public List<Donation> getDonations() {
		return donations;
	}
	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}
	public int getId_donationtype() {
		return id_donationtype;
	}
	public void setId_donationtype(int id_donationtype) {
		this.id_donationtype = id_donationtype;
	}
	public String getName_donationType() {
		return name_donationType;
	}
	public void setName_donationType(String name_donationType) {
		this.name_donationType = name_donationType;
	}
	@Column(name="name_donationtype")
	private String name_donationType;
	
}
