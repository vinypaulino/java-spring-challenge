package com.vinypaulino.challenge.ubs.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinypaulino.challenge.ubs.domain.model.UnidadeBasicaDeSaude;
import com.vinypaulino.challenge.ubs.domain.repository.UnidadeBasicaDeSaudeRepository;

@RestController
@RequestMapping("/api/v1")
public class UbsController {
	
	@Autowired
	private UnidadeBasicaDeSaudeRepository repository;
		
	@GetMapping("/find_ubs")
	public ResponseEntity<List<UnidadeBasicaDeSaude>> list() {
		return ResponseEntity.ok(repository.list());
	}
}
