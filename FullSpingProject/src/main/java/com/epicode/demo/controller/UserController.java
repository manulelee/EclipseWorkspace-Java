package com.epicode.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epicode.demo.model.User;
import com.epicode.demo.service.UserService;


@Controller //RestController
@RequestMapping("/api/users") // endpoint base

// Il controller è il Dispatcher dell'applicazione,
// intercetta le richieste e le esegue

public class UserController {
	
	@Autowired private UserService userService;
	
	
	//@PathVariable:  definisce il path del parametro
	
	//@RequestBody: ??
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		return new ResponseEntity(userService.getAll(), HttpStatus.OK);
	// Response Entity è un wrapper che ingloba stato della risposta e corpo
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id) {
		return new ResponseEntity(userService.getById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser (@RequestBody User user) {
		return new ResponseEntity(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser (@RequestBody User user, @PathVariable Long id) {
		return new ResponseEntity(userService.updateUser(user), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser (@PathVariable Long id) {
		return new ResponseEntity(userService.deleteUser(id), HttpStatus.OK);
	}

}
