package com.epicode.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.demo.model.Postazione;
import com.epicode.demo.model.Prenotazione;
import com.epicode.demo.model.Utente;
import com.epicode.demo.repository.PrenotazioneDaoRepository;
import com.epicode.demo.repository.UtenteDaoRepository;

@Service
public class PrenotazioneService {

	@Autowired PrenotazioneDaoRepository prenotazione;
	@Autowired UtenteService userService;

	
	@Autowired @Qualifier("PrenotazioneFakeBean") ObjectProvider<Prenotazione> prenotazioneFakeProvider;
	@Autowired @Qualifier("PrenotazioneBean") ObjectProvider<Prenotazione> prenotazioneProvider;

	public Prenotazione creaPrenotazioneFake() {
		return prenotazioneFakeProvider.getObject();
	}
	
	public Prenotazione creaPrenotazione(LocalDate giorno, Postazione postazione, Utente utente) {
		return prenotazioneProvider.getObject(giorno, postazione, utente);
	}
	
	public void insertBooking(Prenotazione b) {
		Utente u = b.getUtente();
		AtomicBoolean control = new AtomicBoolean(true);
		List<Prenotazione> lista = u.getListaPrenotazioni();
		List<Prenotazione> prenotazioniPostazione = this.findByGiornoAndPostazione(b.getGiorno(), b.getPostazione());
		if (prenotazioniPostazione.size()==0) {
		lista.forEach(p -> {
		    if (p.getGiorno().equals(b.getGiorno())) {
		        control.set(false);
		    }
		});
		boolean finalControl = control.get();
		if (finalControl) {
			prenotazione.save(b);
			System.out.println("Prenotazione di " + u.getNome() + " " + u.getCognome() + " (" + b.getPostazione().getEdificio().getNome() + " • " + b.getGiorno() + ") salvata nel database...");					u.getListaPrenotazioni().add(b);
			userService.updateUser(u);
		}
		else {
			System.out.println("L'utente " + u.getNome() +" "+ u.getCognome() + " ha già una prenotazione per questa data ("+ b.getGiorno()+ ")...");
		}
		}
		else {
			System.out.println("La postazione " + b.getPostazione().getDescrizione() + " ha già una prenotazione per questa data ("+ b.getGiorno()+ ")...");
		}
				
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
		
	public List<Prenotazione> findByGiornoAndPostazione (LocalDate giorno, Postazione postazione){
		return prenotazione.findByGiornoAndPostazione(giorno, postazione);
	}
}
