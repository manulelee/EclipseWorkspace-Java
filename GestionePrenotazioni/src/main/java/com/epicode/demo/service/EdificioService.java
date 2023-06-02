package com.epicode.demo.service;

import java.util.List;

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
	
	public Edificio creaEdificioFake() {
		return edificioFakeProvider.getObject();
	}
	
	public Edificio creaEdificio(String nome, String via, int civico, String citta) {
		return edificioProvider.getObject(nome, via, civico, citta);
	}
	
	public void insertBuilding(Edificio e) {
		edificio.save(e);
		System.out.println("Edificio " + e.getNome() + " (" + e.getCitta() + ") salvato nel database...");
	}
	
	public void updateBuilding(Edificio e) {
		edificio.save(e);
		System.out.println("Edificio " + e.getNome() + " (" + e.getCitta() + ") modificato nel database...");
	}
	
	public void deleteBuilding(Edificio e) {
		edificio.delete(e);
		System.out.println("Edificio " + e.getNome() + " (" + e.getCitta() + ") eliminato dal database...");
	}
	
	public Edificio getByID(int id) {
		return edificio.findById(id).get();
	}
	
	public List<Edificio> getAll() {
		return edificio.findAll();
	}
}
