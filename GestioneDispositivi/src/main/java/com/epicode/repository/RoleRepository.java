package com.epicode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.enumeration.ERole;
import com.epicode.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
