package com.epicode.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.demo.model.Utente;

public interface UtenteDaoRepository extends JpaRepository<Utente, Integer> {

}
