package com.vinypaulino.challenge.ubs.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UnidadeBasicaDeSaude {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String city;
	private String phone;
	//private GeographCode geoCode;
	//private Scores scores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/*
	 * public GeographCode getGeoCode() { return geoCode; }
	 * 
	 * public void setGeoCode(GeographCode geoCode) { this.geoCode = geoCode; }
	 * 
	 * public Scores getScores() { return scores; }
	 * 
	 * public void setScores(Scores scores) { this.scores = scores; }
	 */

}
