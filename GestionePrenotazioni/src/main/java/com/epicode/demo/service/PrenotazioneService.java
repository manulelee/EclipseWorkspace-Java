package com.epicode.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.demo.model.Postazione;
import com.epicode.demo.model.Prenotazione;
import com.epicode.demo.model.Utente;
import com.epicode.demo.repository.PrenotazioneDaoRepository;

@Service
public class PrenotazioneService {

	@Autowired PrenotazioneDaoRepository prenotazione;
	
	@Autowired @Qualifier("PrenotazioneFakeBean") ObjectProvider<Prenotazione> prenotazioneFakeProvider;
	@Autowired @Qualifier("PrenotazioneBean") ObjectProvider<Prenotazione> prenotazioneProvider;

	public Prenotazione creaPostazioneFake() {
		return prenotazioneFakeProvider.getObject();
	}
	
	public Prenotazione creaPostazione(LocalDate giorno, Postazione postazione, Utente utente) {
		return prenotazioneProvider.getObject(giorno, postazione, utente);
	}
	
	public void insertBooking(Prenotazione p) {
		prenotazione.save(p);
		System.out.println("Prenotazione di " + p.getUtente().getNome() + " " + p.getUtente().getCognome() + " (" + p.getPostazione().getEdificio().getNome() + " • " + p.getGiorno() + ") salvata nel database...");
	}
	
	public void updateBooking(Prenotazione p) {
		prenotazione.save(p);
		System.out.println("Prenotazione di " + p.getUtente().getNome() + " " + p.getUtente().getCognome() + " (" + p.getPostazione().getEdificio().getNome() + " • " + p.getGiorno() + ") modificata nel database...");
	}
	
	public void deleteBooking(Prenotazione p) {
		prenotazione.delete(p);
		System.out.println("Prenotazione di " + p.getUtente().getNome() + " " + p.getUtente().getCognome() + " (" + p.getPostazione().getEdificio().getNome() + " • " + p.getGiorno() + ") eliminata dal database...");
	}
	
	public Prenotazione getByID(int id) {
		return prenotazione.findById(id).get();
	}
	
	public List<Prenotazione> getAll() {
		return prenotazione.findAll();
	}
}
