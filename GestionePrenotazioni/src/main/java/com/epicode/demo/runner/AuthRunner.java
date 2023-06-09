package com.epicode.demo.runner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.epicode.demo.model.Ruolo;
import com.epicode.demo.model.TipoRuolo;
import com.epicode.demo.repository.RoleRepository;
import com.epicode.demo.repository.UtenteDaoRepository;
import com.epicode.demo.service.AuthService;





@Component
public class AuthRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;
	@Autowired UtenteDaoRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired AuthService authService;
	
	private Set<Ruolo> adminRole;
	private Set<Ruolo> moderatorRole;
	private Set<Ruolo> userRole;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
		// Metodo da lanciare solo la prima volta
		// Serve per salvare i ruoli nel DB
//		setRoleDefault();
		
	}
	
	private void setRoleDefault() {
		Ruolo admin = new Ruolo();
		admin.setRuolo(TipoRuolo.ADMIN);
		roleRepository.save(admin);
		
		Ruolo user = new Ruolo();
		user.setRuolo(TipoRuolo.USER);
		roleRepository.save(user);

//		userRole = new HashSet<Role>();
//		userRole.add(user);
	}
	
	

}
