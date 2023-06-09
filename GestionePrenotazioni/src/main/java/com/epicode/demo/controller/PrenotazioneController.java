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

import com.epicode.demo.model.Prenotazione;
import com.epicode.demo.model.Utente;
import com.epicode.demo.service.PrenotazioneService;


@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {
	
	@Autowired PrenotazioneService prenotazione_Service;
	
	@GetMapping
	public List<Prenotazione> getAllPrenotazioni(){
		return prenotazione_Service.getAll();
	}
	
	@GetMapping("/{id}")
	public Prenotazione getUtente(@PathVariable Integer id){
		return  prenotazione_Service.getByID(id);
	}
	
	@PostMapping
	public Prenotazione insertPrenotazione(@RequestBody Prenotazione p) {
	return prenotazione_Service.insertBooking(p);
	}
	
	@PutMapping("/{id}")
	public Prenotazione modificaPrenotazione(@RequestBody Prenotazione p,@PathVariable Integer id) {
		return prenotazione_Service.updateBooking(p);
	}
	@DeleteMapping("/{id}")
	public String deletePrenotazione(@PathVariable Integer id) {
		return prenotazione_Service.deleteBooking(id);
	}
}
