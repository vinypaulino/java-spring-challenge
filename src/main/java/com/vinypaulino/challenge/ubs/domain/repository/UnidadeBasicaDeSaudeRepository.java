package com.vinypaulino.challenge.ubs.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinypaulino.challenge.ubs.domain.model.UnidadeBasicaDeSaude;

@Repository
public interface UnidadeBasicaDeSaudeRepository extends JpaRepository<UnidadeBasicaDeSaude, Long> {

}
