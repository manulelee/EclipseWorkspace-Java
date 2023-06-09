package com.epicode.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.demo.model.Ruolo;
import com.epicode.demo.model.TipoRuolo;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Ruolo, Long> {
    
	Optional<Ruolo> findByRuolo(TipoRuolo roleName);

}
