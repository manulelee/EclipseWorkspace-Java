package com.epicode.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.demo.model.User;

@Repository
// Nel Repository definiamo i metodi della classe DAO
public interface UserDAORepository extends JpaRepository<User, Long> {
	
//	public boolean existsById(long Id); // per verificare l'esistenza di un utente (già presente in JPA Repository)
	
	public boolean existsByEmail (String email); // per verificare se esiste già un utente con la stess mail
	
}
