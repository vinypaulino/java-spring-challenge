package com.vinypaulino.challenge.ubs.domain.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vinypaulino.challenge.ubs.domain.model.UnidadeBasicaDeSaude;
import com.vinypaulino.challenge.ubs.domain.repository.UnidadeBasicaDeSaudeRepository;

@Component
public class UnidadeBasicaDeSaudeRepositoryImpl implements UnidadeBasicaDeSaudeRepository{

	@Override
	public List<UnidadeBasicaDeSaude> list() {
		UnidadeBasicaDeSaude unidadeSaude = new UnidadeBasicaDeSaude();
		unidadeSaude.setId(1L);
		unidadeSaude.setName("stub");
		unidadeSaude.setAddress("Rua Teste");
		
		List<UnidadeBasicaDeSaude> unidadesBasicas = new ArrayList<UnidadeBasicaDeSaude>();
		unidadesBasicas.add(unidadeSaude);
		
		return unidadesBasicas;
	}

}
