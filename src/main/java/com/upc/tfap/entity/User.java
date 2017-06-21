package com.upc.tfap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class User {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id_person")
		private int id;
	
		@Column(name="identity_number_person")
		private String dniruc;  
	
		@Column(name="name_person")
		private String nombre;
		
		@Column(name="apellido_person")
		private String apellido;
		
		@Column(name="img_person")
		private String foto;
		
		@Column(name="password_person")
		private String password;
		
		@Column(name="type_person")
		private String tipo;
		
		@Column(name="email_person")
		private String email;

		@OneToMany
		private List<Event> events;
		
		@OneToMany
		private List<GatheringCenter> gathering_centers;
		
		@OneToMany(cascade = CascadeType.ALL)
		//@OneToMany
		private List<Donation> donations;
		
		public List<Event> getEvents() {
			return events;
		}

		public void setEvents(List<Event> events) {
			this.events = events;
		}

		public List<GatheringCenter> getGathering_centers() {
			return gathering_centers;
		}

		public void setGathering_centers(List<GatheringCenter> gathering_centers) {
			this.gathering_centers = gathering_centers;
		}

		public List<Donation> getDonations() {
			return donations;
		}

		public void setDonations(List<Donation> donations) {
			this.donations = donations;
		}
		public User(){
			
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		};
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFoto() {
			return foto;
		}
		public void setFoto(String foto) {
			this.foto = foto;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDniruc() {
			return dniruc;
		}

		public void setDniruc(String dniruc) {
			this.dniruc = dniruc;
		}

		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		
	}

