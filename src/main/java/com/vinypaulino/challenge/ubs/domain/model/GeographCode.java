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

}
