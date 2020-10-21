package com.vinypaulino.challenge.ubs.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Embeddable
public class GeographCode {

	private static final int RADIUS_OF_THE_EARTH = 6371;

	@Column(name="geo_code_lat")
	private double latitude;
	
	@Column(name="geo_code_log")
	private double longitude;
	
	@Transient
	private double distance;
	
	public double calcDistance(double lat1, double lon1  ) {

	    double latDistance = Math.toRadians(this.getLatitude() - lat1);
	    double lonDistance = Math.toRadians(this.getLongitude() - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(getLatitude()))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    this.distance = convertToMeters(c);

	    this.distance = Math.pow(distance, 2);

	    setDistance(Math.sqrt(distance));
	    return this.distance;
	}

	private double convertToMeters(double c) {
		return RADIUS_OF_THE_EARTH * c * 1000;
	}

}
