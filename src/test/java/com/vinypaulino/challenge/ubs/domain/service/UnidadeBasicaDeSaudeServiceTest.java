package com.vinypaulino.challenge.ubs.domain.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.vinypaulino.challenge.ubs.domain.model.GeographCode;
import com.vinypaulino.challenge.ubs.domain.model.UnidadeBasicaDeSaude;
import com.vinypaulino.challenge.ubs.domain.repository.UnidadeBasicaDeSaudeRepository;


@RunWith(MockitoJUnitRunner.class)
public class UnidadeBasicaDeSaudeServiceTest {
	
	@Mock
	private UnidadeBasicaDeSaudeRepository repository;
	
	@Test
	public void givenSizeEqualsTwo_When_listUBSs_ShouldReturnTwoUBSs() {
		
		List<UnidadeBasicaDeSaude> units = new ArrayList<>();
		Page<UnidadeBasicaDeSaude> pageable = new PageImpl<UnidadeBasicaDeSaude>(units);
		int page = 2;
		@SuppressWarnings("deprecation")
		PageRequest pageRequest = new PageRequest(1, 2); 
		
		
		when(repository.findAll()).thenReturn(getList());
		UnidadeBasicaDeSaudeService service = new UnidadeBasicaDeSaudeService(repository);
		Page<UnidadeBasicaDeSaude> list = service.list(-42.5444574, -90.8628988265978, pageRequest);
		Assert.assertTrue(list.getSize() == page);
	}
	@Test
	public void givenPageEqualsOne_When_listUBSs_ShouldReturnPageNumberOne() {
		
		List<UnidadeBasicaDeSaude> units = new ArrayList<>();
		Page<UnidadeBasicaDeSaude> pageable = new PageImpl<UnidadeBasicaDeSaude>(units);
		int page = 2;
		@SuppressWarnings("deprecation")
		PageRequest pageRequest = new PageRequest(1, 2); 
		
		
		when(repository.findAll()).thenReturn(getList());
		UnidadeBasicaDeSaudeService service = new UnidadeBasicaDeSaudeService(repository);
		Page<UnidadeBasicaDeSaude> list = service.list(-42.5444574, -90.8628988265978, pageRequest);
		Assert.assertTrue(list.getNumber() == 1);
	}
	
	private List<UnidadeBasicaDeSaude> getList() {
		
		GeographCode geoCode = new GeographCode();
		geoCode.setLatitude(-30.2076065540305);
		geoCode.setLongitude(-57.5517725944502);
		
		UnidadeBasicaDeSaude unidadeBasicaDeSaude = new UnidadeBasicaDeSaude();
		unidadeBasicaDeSaude.setAddress("District test");
		unidadeBasicaDeSaude.setName("ubs test");
		unidadeBasicaDeSaude.setGeoCode(geoCode);
		
		GeographCode geoCode1 = new GeographCode();
		geoCode1.setLatitude(-30.2076065540305);
		geoCode1.setLongitude(-57.5517725944502);
		
		UnidadeBasicaDeSaude unidadeBasicaDeSaude1 = new UnidadeBasicaDeSaude();
		unidadeBasicaDeSaude1.setAddress("District test 1");
		unidadeBasicaDeSaude1.setName("ubs test 1");
		unidadeBasicaDeSaude1.setGeoCode(geoCode);
		
		GeographCode geoCode2 = new GeographCode();
		geoCode2.setLatitude(-30.2076065540305);
		geoCode2.setLongitude(-57.5517725944502);
		
		UnidadeBasicaDeSaude unidadeBasicaDeSaude2 = new UnidadeBasicaDeSaude();
		unidadeBasicaDeSaude2.setAddress("District test 2");
		unidadeBasicaDeSaude2.setName("ubs test 2");
		unidadeBasicaDeSaude2.setGeoCode(geoCode);
		
		List<UnidadeBasicaDeSaude> returnedList = new ArrayList<>();
		returnedList.add(unidadeBasicaDeSaude);
		returnedList.add(unidadeBasicaDeSaude1);
		returnedList.add(unidadeBasicaDeSaude2);
		return returnedList;
	}
	
}
