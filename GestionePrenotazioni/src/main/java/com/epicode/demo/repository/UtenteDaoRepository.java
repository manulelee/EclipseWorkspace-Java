package com.epicode.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.demo.model.Utente;

public interface UtenteDaoRepository extends JpaRepository<Utente, Integer> {
	Optional<Utente> findByUsernameOrEmail(String username, String email);
	
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
