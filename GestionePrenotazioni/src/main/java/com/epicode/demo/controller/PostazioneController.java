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
import com.epicode.demo.model.Postazione;
import com.epicode.demo.service.PostazioneService;

@RestController
@RequestMapping("api/postazioni")
public class PostazioneController {
	
	@Autowired PostazioneService postazione_Service;
	
	@GetMapping
	public List<Postazione> getAllPostazioni(){
		return postazione_Service.getAll();
	}
	
	@PostMapping
	public Postazione insertPostazione(@RequestBody Postazione p) {
		return postazione_Service.insertWorkstation(p);
	}
	
	@GetMapping("/{id}")
	public Postazione getPostazione(@PathVariable Integer id){
		return  postazione_Service.getByID(id);
	}
		
	@PutMapping("/{id}")
	public Postazione modificaPostazione(@RequestBody Postazione p,@PathVariable Integer id) {
		return postazione_Service.updateWorkstation(p);
	}
	
	@DeleteMapping("/{id}")
	public String deletePostazione(@PathVariable Integer id) {
		return postazione_Service.deleteWorkstation(id);
	}
}
