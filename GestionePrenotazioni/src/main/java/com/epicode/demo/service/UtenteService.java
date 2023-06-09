package com.epicode.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	public static Logger log = LoggerFactory.getLogger(UtenteService.class);
	
	public Utente creaUtenteAdmin() {
		return utenteAdminProvider.getObject();
	}
	
	public Utente creaUtenteFake() {
		return utenteFakeProvider.getObject();
	}
	
	public Utente creaUtente(String nome, String cognome, String username, String email) {
		return utenteProvider.getObject(nome, cognome, username, email);
	}
	
	public Utente insertUser(Utente u) {
		return utente.save(u);
		//log.info("Utente " + u.getNome() + " " + u.getCognome() + " salvato nel database...");
	}
	
	public Utente updateUser(Utente u) {
		return utente.save(u);
		//log.info("Utente " + u.getNome() + " " + u.getCognome() + " modificato nel database...");
	}
	
	public String deleteUser(Integer id) {
		utente.deleteById(id);
		//log.info("Utente " + u.getNome() + " " + u.getCognome() + " eliminato dal database...");
		return "Utente " + id + " eliminato";
	}
	
	public Utente getByID(int id) {
		return utente.findById(id).get();
	}
	
	public List<Utente> getAll() {
		return utente.findAll();
	}
}
