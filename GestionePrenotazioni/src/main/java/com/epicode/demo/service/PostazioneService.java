package com.epicode.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.demo.model.Edificio;
import com.epicode.demo.model.Postazione;
import com.epicode.demo.model.TipoPostazione;
import com.epicode.demo.repository.PostazioneDaoRepository;

@Service
public class PostazioneService {
	
	@Autowired PostazioneDaoRepository postazione;
	
	@Autowired @Qualifier("PostazioneFakeBean") ObjectProvider<Postazione> postazioneFakeProvider;
	@Autowired @Qualifier("PostazioneBean") ObjectProvider<Postazione> postazioneProvider;

	public static Logger log = LoggerFactory.getLogger(PostazioneService.class);
	
	public Postazione creaPostazioneFake() {
		return postazioneFakeProvider.getObject();
	}
	
	public Postazione creaPostazione(String nome, String cognome, String username, String email) {
		return postazioneProvider.getObject(nome, cognome, username, email);
	}
	
	public Postazione insertWorkstation(Postazione p) {
		return postazione.save(p);
		//log.info("Postazione " + p.getTipo() + " (" + p.getEdificio().getNome() + ") salvata nel database...");
	}
	
	public Postazione updateWorkstation(Postazione p) {
		return postazione.save(p);
		//log.info("Postazione " + p.getTipo() + " (" + p.getEdificio().getNome() + ") modificata nel database...");
	}
	
	public String deleteWorkstation(Integer id) {
		postazione.deleteById(id);
		//log.info("Postazione " + p.getTipo() + " (" + p.getEdificio().getNome() + ") eliminata dal database...");
		return "Postazione "+ id + " eliminata";
	}
	
	public Postazione getByID(int id) {
		return postazione.findById(id).get();
	}
	
	public List<Postazione> getAll() {
		return postazione.findAll();
	}
	
	public List<Postazione> findByEdificioAndTipo (Edificio edificio, TipoPostazione tipo){
		return postazione.findByEdificioAndTipo (edificio, tipo);
	}
	
	public List<Postazione> findByCittaAndTipo(String citta, TipoPostazione tipo){
		return postazione.findByCittaAndTipo(citta, tipo);
	}
	
}
