package com.epicode.demo.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.demo.model.Postazione;
import com.epicode.demo.repository.PostazioneDaoRepository;

@Service
public class PostazioneService {
	
	@Autowired PostazioneDaoRepository postazione;
	
	@Autowired @Qualifier("PostazioneFakeBean") ObjectProvider<Postazione> postazioneFakeProvider;
	@Autowired @Qualifier("PostazioneBean") ObjectProvider<Postazione> postazioneProvider;

	public Postazione creaPostazioneFake() {
		return postazioneFakeProvider.getObject();
	}
	
	public Postazione creaPostazione(String nome, String cognome, String username, String email) {
		return postazioneProvider.getObject(nome, cognome, username, email);
	}
	
	public void insertWorkstation(Postazione p) {
		postazione.save(p);
		System.out.println("Postazione " + p.getTipo() + " (" + p.getEdificio().getNome() + ") salvata nel database...");
	}
	
	public void updateWorkstation(Postazione p) {
		postazione.save(p);
		System.out.println("Postazione " + p.getTipo() + " (" + p.getEdificio().getNome() + ") modificata nel database...");
	}
	
	public void deleteWorkstation(Postazione p) {
		postazione.delete(p);
		System.out.println("Postazione " + p.getTipo() + " (" + p.getEdificio().getNome() + ") eliminata dal database...");
	}
	
	public Postazione getByID(int id) {
		return postazione.findById(id).get();
	}
	
	public List<Postazione> getAll() {
		return postazione.findAll();
	}
}