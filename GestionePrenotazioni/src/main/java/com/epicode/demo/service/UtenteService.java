package com.epicode.demo.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.demo.model.Utente;
import com.epicode.demo.repository.UtenteDaoRepository;


@Service
public class UtenteService {

	@Autowired UtenteDaoRepository utente;
	
	@Autowired @Qualifier("UtenteAdminBean") ObjectProvider<Utente> utenteAdminProvider;
	@Autowired @Qualifier("UtenteFakeBean") ObjectProvider<Utente> utenteFakeProvider;
	@Autowired @Qualifier("UtenteBean") ObjectProvider<Utente> utenteProvider;
	
	public Utente creaUtenteAdmin() {
		return utenteAdminProvider.getObject();
	}
	
	public Utente creaUtenteFake() {
		return utenteFakeProvider.getObject();
	}
	
	public Utente creaUtente(String nome, String cognome, String username, String email) {
		return utenteProvider.getObject(nome, cognome, username, email);
	}
	
	public void insertUser(Utente u) {
		utente.save(u);
		System.out.println("Utente " + u.getNome() + " " + u.getCognome() + " salvato nel database...");
	}
	
	public void updateUser(Utente u) {
		utente.save(u);
		System.out.println("Utente " + u.getNome() + " " + u.getCognome() + " modificato nel database...");
	}
	
	public void deleteUser(Utente u) {
		utente.delete(u);
		System.out.println("Utente " + u.getNome() + " " + u.getCognome() + " eliminato dal database...");
	}
	
	public Utente getByID(int id) {
		return utente.findById(id).get();
	}
	
	public List<Utente> getAll() {
		return utente.findAll();
	}
}
