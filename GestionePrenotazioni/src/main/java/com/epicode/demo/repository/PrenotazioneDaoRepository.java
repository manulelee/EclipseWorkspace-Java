package com.epicode.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.demo.model.Prenotazione;

public interface PrenotazioneDaoRepository extends JpaRepository<Prenotazione, Integer>{

}
