package com.epicode.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.epicode.demo.model.Postazione;
import com.epicode.demo.model.Prenotazione;

public interface PrenotazioneDaoRepository extends JpaRepository<Prenotazione, Integer>{
	
	@Query("SELECT Prenotazione AS postazione FROM Prenotazione p WHERE p.giorno = :data and p.postazione = :post")
	public List<Prenotazione> workstationBookedOnData(LocalDate data, Postazione post);
	
	public List<Prenotazione> findByGiornoAndPostazione (LocalDate giorno, Postazione postazione);
}

