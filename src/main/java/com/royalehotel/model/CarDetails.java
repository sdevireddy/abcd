package com.royalehotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cardetails")
public class CarDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private Long id;
	@Column(name = "COMPANY_NAME")
	private String name;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "CARTYPE_ID", nullable = false, referencedColumnName = "CARTYPE_ID")
	private CarType type;
	
	CarDetails(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String cityName) {
		this.name = cityName;
	}

	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}

}
