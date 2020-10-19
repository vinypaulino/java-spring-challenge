package com.vinypaulino.challenge.ubs.domain.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UnidadeBasicaDeSaude {

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
	
	public double distance(double lat1, double lon1  ) {

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(this.geoCode.getLatitude() - lat1);
	    double lonDistance = Math.toRadians(this.geoCode.getLongitude() - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(this.geoCode.getLatitude()))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    distance = Math.pow(distance, 2);

	    return Math.sqrt(distance);
	}

}
