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

}
