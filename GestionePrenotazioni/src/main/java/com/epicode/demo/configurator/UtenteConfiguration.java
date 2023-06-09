//package com.epicode.demo.configurator;
//
//import java.util.Locale;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
//import com.epicode.demo.model.Utente;
//import com.github.javafaker.Faker;
//
//@Configuration
//public class UtenteConfiguration {
//
//	@Value("${user.admin.name}") private String nomeAdmin;
//	@Value("${user.admin.lastname}") private String cognomeAdmin;
//	@Value("${user.admin.city}") private String cittaAdmin;
//	@Value("${user.admin.username}") private String usernameAdmin;
//	@Value("${user.admin.email}") private String emailAdmin;
//	
//	@Bean("UtenteAdminBean")
//	@Scope("singleton")
//	public Utente admin() {
//		return new Utente(nomeAdmin, cognomeAdmin, usernameAdmin.toUpperCase(), emailAdmin);
//	}
//	
//	@Bean("UtenteFakeBean")
//	@Scope("prototype")
//	public Utente fake() {
//		Faker fake = Faker.instance(new Locale("it-IT"));
//		String nome = fake.name().firstName();
//		String cognome =  fake.name().lastName();
//		String username = (cognome + "." + nome).toUpperCase();
//		String email = (nome.charAt(0) + "."+ cognome +"@epicode.com").toLowerCase();
//		Utente userFake = new Utente(nome,cognome, username, email);
//		return userFake;
//	}
//	
//	@Bean("UtenteBean")
//	@Scope("prototype")
//	public Utente custom(String nome, String cognome, String username, String email) {
//		return new Utente(nome, cognome, username.toUpperCase(), email);
//	}
//}
