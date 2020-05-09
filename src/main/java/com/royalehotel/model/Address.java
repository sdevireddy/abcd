package com.royalehotel.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long address_id;
	@Column(name = "address_line1")
	private String addressLine1;
	@Column(name = "address_line2")
	private String addressLine2;
	@Column(name = "street")
	private String street;
	@Column(name = "state")
	private String state;
	@Column(name = "city")
	private String city;
	@Column(name = "country")
	private String country;
	
	/*
	 * @OneToOne(mappedBy ="address") private Users user;
	 */
	Address() {
		
	}

	public Long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}

	public String getAdddressLine1() {
		return addressLine1;
	}

	public void setAdddressLine1(String adddress_line1) {
		this.addressLine1 = adddress_line1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String address_line2) {
		this.addressLine2 = address_line2;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	/*
	 * public Users getUser() { return user; }
	 * 
	 * public void setUser(Users user) { this.user = user; }
	 */
	
	
	
	
	
	
}