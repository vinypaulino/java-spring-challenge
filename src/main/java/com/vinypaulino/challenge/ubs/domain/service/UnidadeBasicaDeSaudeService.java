package com.vinypaulino.challenge.ubs.domain.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vinypaulino.challenge.ubs.domain.model.UnidadeBasicaDeSaude;
import com.vinypaulino.challenge.ubs.domain.repository.UnidadeBasicaDeSaudeRepository;

@Service
public class UnidadeBasicaDeSaudeService {

	private UnidadeBasicaDeSaudeRepository repository;

	public UnidadeBasicaDeSaudeService(UnidadeBasicaDeSaudeRepository repository) {
		this.repository = repository;
	}
	
	public Page<UnidadeBasicaDeSaude> list(double lat, double longitude, Pageable pageable) {
		List<UnidadeBasicaDeSaude> units = repository.findAll();

		units.forEach((UnidadeBasicaDeSaude unit) -> {
			unit.getGeoCode().calcDistance(lat, longitude);
		});
		Collections.sort(units);

		List<List<UnidadeBasicaDeSaude>> batches = paginateResult(pageable, units);

		Page<UnidadeBasicaDeSaude> result = new PageImpl<>(batches.get(pageable.getPageNumber() - 1), pageable,
				repository.count());

		return result;
	}

	private List<List<UnidadeBasicaDeSaude>> paginateResult(Pageable pageable, List<UnidadeBasicaDeSaude> units) {
		int i = 0;
		List<List<UnidadeBasicaDeSaude>> batches = new ArrayList<List<UnidadeBasicaDeSaude>>();
		while (i < units.size()) {
			int nextInc = Math.min(units.size() - i, pageable.getPageSize());
			List<UnidadeBasicaDeSaude> batch = units.subList(i, i + nextInc);
			batches.add(batch);
			i = i + nextInc;
		}
		return batches;
	}
}
