package com.epicode.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.demo.model.User;
import com.epicode.demo.repository.UserDAORepository;

import jakarta.persistence.EntityExistsException;

@Service
// Nel Service definiamo tutti i metodi CRUD
public class UserService {
	
	// Dependency Injection Repository
	@Autowired private UserDAORepository udr;
	
	public User getById(Long id) {
		if(!udr.existsById(id)) {
			throw new EntityExistsException("This user does not exist");
		}
		return udr.findById(id).get(); // .get() per castare da Optional a User
	}
	
	public List<User> getAll(){
		return udr.findAll();
	}
	
	public User createUser(User u) {
		if(!udr.existsByEmail(u.getEmail())) {
			throw new EntityExistsException("Email già registrata nel database");
		}
		return udr.save(u); // save() ritorna l'oggetto salvato
	}
	
	public User updateUser (User u) {
		return udr.save(u); // identico al createUser() se è presente l'id effettuerà l'update
	}
	
	public String deleteUser (Long id) {
		udr.deleteById(id);
		return "Utente " + id + " eliminato dal database";
	}

}
