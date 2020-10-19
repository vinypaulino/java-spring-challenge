package com.vinypaulino.challenge.ubs.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class GeographCode {

	@Column(name="geo_code_lat")
	private double latitude;
	
	@Column(name="geo_code_log")
	private double longitude;
	
	public double distance(double lat1, double lon1  ) {

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(getLatitude() - lat1);
	    double lonDistance = Math.toRadians(getLongitude() - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(getLatitude()))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    distance = Math.pow(distance, 2);

	    return Math.sqrt(distance);
	}

}
