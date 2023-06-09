package com.epicode.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.demo.model.Edificio;
import com.epicode.demo.model.Utente;
import com.epicode.demo.service.UtenteService;

@RestController
@RequestMapping("/api/users")
public class UtenteController {
	
	@Autowired UtenteService utente_Service;
	
	
	@GetMapping
	public List<Utente> getAllUtenti(){
		return utente_Service.getAll();
	}
	
	@GetMapping("/{id}")
	public Utente getUtente(@PathVariable Integer id){
		return  utente_Service.getByID(id);
	}
	
	@PostMapping
	public Utente insertUtente(@RequestBody Utente u) {
	return utente_Service.insertUser(u);
	}
	
	@PutMapping("/{id}")
	public Utente modificaUtente(@RequestBody Utente u,@PathVariable Integer id) {
		return utente_Service.updateUser(u);
	}
	@DeleteMapping("/{id}")
	public String deleteUtente(@PathVariable Integer id) {
		return utente_Service.deleteUser(id);
	}
}
