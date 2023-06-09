//package com.epicode.demo.configurator;
//
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.Locale;
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
//import com.epicode.demo.model.Postazione;
//import com.epicode.demo.model.Prenotazione;
//import com.epicode.demo.model.Utente;
//import com.epicode.demo.service.PostazioneService;
//import com.epicode.demo.service.UtenteService;
//import com.github.javafaker.Faker;
//
//@Configuration
//public class PrenotazioneConfiguration {
//	
//	@Autowired private UtenteService userService;
//	@Autowired private PostazioneService workstationService;
//	
//	@Bean("PrenotazioneFakeBean")
//	@Scope("prototype")
//	public Prenotazione fake() {
//		Faker fake = Faker.instance(new Locale("it-IT"));
//		LocalDate giorno = fake.date().future(10, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//		Utente utente =  userService.getByID(fake.random().nextInt(1,userService.getAll().size()));
//		Postazione postazione = workstationService.getByID(fake.random().nextInt(1,workstationService.getAll().size()));
//		Prenotazione prenotazioneFake = new Prenotazione(giorno, postazione, utente);
//		return prenotazioneFake;
//	}
//	
//	@Bean("PrenotazioneBean")
//	@Scope("prototype")
//	public Prenotazione custom(LocalDate giorno, Postazione postazione, Utente utente) {
//		return new Prenotazione(giorno, postazione, utente);
//	}
//
//}
