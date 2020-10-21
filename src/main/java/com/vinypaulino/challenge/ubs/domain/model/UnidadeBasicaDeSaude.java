package com.vinypaulino.challenge.ubs.domain.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class UnidadeBasicaDeSaude implements Comparable<UnidadeBasicaDeSaude>{

	public UnidadeBasicaDeSaude() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String city;
	private String phone;
	
	@Embedded
	private GeographCode geoCode;
	
	@Embedded
	private Scores scores;

	@Override
	public int compareTo(UnidadeBasicaDeSaude o) {
		return Double.compare(this.geoCode.getDistance(), o.getGeoCode().getDistance());
	}
	


}
