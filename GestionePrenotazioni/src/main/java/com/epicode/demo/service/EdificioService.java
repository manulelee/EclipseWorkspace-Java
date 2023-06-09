package com.epicode.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.demo.model.Edificio;
import com.epicode.demo.repository.EdificioDaoRepository;


@Service
public class EdificioService {
	
	@Autowired EdificioDaoRepository edificio;
	
	@Autowired @Qualifier("EdificioFakeBean") ObjectProvider<Edificio> edificioFakeProvider;
	@Autowired @Qualifier("EdificioBean") ObjectProvider<Edificio> edificioProvider;
	
	public static Logger log = LoggerFactory.getLogger(EdificioService.class);
	
	public Edificio creaEdificioFake() {
		return edificioFakeProvider.getObject();
	}
	
	public Edificio creaEdificio(String nome, String via, int civico, String citta) {
		return edificioProvider.getObject(nome, via, civico, citta);
	}
	
	public Edificio insertBuilding(Edificio e) {
		//log.info("Edificio " + e.getNome() + " (" + e.getCitta() + ") salvato nel database...");
		return edificio.save(e);
	}
	
	public Edificio updateBuilding(Edificio e) {
		//log.info("Edificio " + e.getNome() + " (" + e.getCitta() + ") modificato nel database...");
		return edificio.save(e);
	}
	
	public String deleteBuilding(Integer id) {
		edificio.deleteById(id);
		//log.info("Edificio " + e.getNome() + " (" + e.getCitta() + ") eliminato dal database...");
		return "Edificio " + id + " eliminato";
	}
	
	public Edificio getByID(int id) {
		return edificio.findById(id).get();
	}
	
	public List<Edificio> getAll() {
		return edificio.findAll();
	}
}
