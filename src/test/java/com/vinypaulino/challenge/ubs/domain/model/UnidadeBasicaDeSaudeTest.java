package com.vinypaulino.challenge.ubs.domain.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnidadeBasicaDeSaudeTest {
	
	@Test
	public void should_caulculate_distance_between_two_points() {
		GeographCode geoCode = new GeographCode();
		geoCode.setLatitude(-10.9112370014188);
		geoCode.setLongitude(-37.0620775222768);
		
		UnidadeBasicaDeSaude unidadeBasicaDeSaude = new UnidadeBasicaDeSaude();
		unidadeBasicaDeSaude.setGeoCode(geoCode);
		
		double distance = unidadeBasicaDeSaude.distance(-23.604936, -46.692999);
		
		
		assertEquals(1741384.810963698d, distance, 00001);
	}

}
