package com.epicode.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.epicode.demo.model.Edificio;
import com.epicode.demo.model.Postazione;
import com.epicode.demo.model.TipoPostazione;

public interface PostazioneDaoRepository extends JpaRepository<Postazione, Integer>{

	public List<Postazione> findByEdificioAndTipo (Edificio edificio, TipoPostazione tipo);
	
	@Query("SELECT p FROM Postazione p WHERE p.tipo = :tipo AND edificio in(SELECT e FROM Edificio e WHERE e.citta = :citta)")
    public List<Postazione> findByCittaAndTipo(String citta, TipoPostazione tipo);
}
