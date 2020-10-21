package com.vinypaulino.challenge.ubs.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vinypaulino.challenge.ubs.domain.model.UnidadeBasicaDeSaude;
import com.vinypaulino.challenge.ubs.domain.service.UnidadeBasicaDeSaudeService;

@RestController
@RequestMapping("/api/v1")
public class UbsController {

	@Autowired
	private UnidadeBasicaDeSaudeService service;

	@ResponseBody
	@GetMapping("/find_ubs")
	public Page<UnidadeBasicaDeSaude> list(@RequestParam(required = true)  String query, Pageable pageable) {

		String[] geoCode = query.split(",");
	    
		 
		Page<UnidadeBasicaDeSaude> result = service.list(Double.parseDouble(geoCode[0]),
												         Double.parseDouble(geoCode[1]),
														 pageable);
		
		
		return result;
	}
}
