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
import com.epicode.demo.service.EdificioService;

@RestController
@RequestMapping("api/edifici")
public class EdificioController {

	@Autowired EdificioService edificio_Service;
	
	@GetMapping
	public List<Edificio> getAllEdifici(){
		return edificio_Service.getAll();
	}
	
	@GetMapping("/{id}")
	public Edificio getEdificio(@PathVariable Integer id){
		return  edificio_Service.getByID(id);
	}
	
	@PostMapping
	public Edificio insertEdificio(@RequestBody Edificio e) {
		return edificio_Service.insertBuilding(e);
	}
	
	@PutMapping("/{id}")
	public Edificio editEdificio(@RequestBody Edificio e,@PathVariable Integer id) {
		return  edificio_Service.updateBuilding(e);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEdificio(@PathVariable Integer id) {
		return edificio_Service.deleteBuilding(id);
	}
}
