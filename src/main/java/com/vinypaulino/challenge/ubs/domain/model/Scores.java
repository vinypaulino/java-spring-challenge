package com.vinypaulino.challenge.ubs.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Scores {

	@Column(name="score_size")
	private int size;

	@Column(name="score_adaptation_for_seniors")
	private int adaptation_for_seniors;

	@Column(name="score_medical_equipment")
	private int medical_equipment;
	
	@Column(name="score_medicine")
	private int medicine;

	
}
