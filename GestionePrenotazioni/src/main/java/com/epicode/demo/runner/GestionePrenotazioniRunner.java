package com.epicode.demo.runner;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epicode.demo.model.Edificio;
import com.epicode.demo.model.Postazione;
import com.epicode.demo.model.Prenotazione;
import com.epicode.demo.model.Utente;
import com.epicode.demo.service.EdificioService;
import com.epicode.demo.service.PostazioneService;
import com.epicode.demo.service.PrenotazioneService;
import com.epicode.demo.service.UtenteService;
import com.github.javafaker.Faker;



@Component
public class GestionePrenotazioniRunner implements ApplicationRunner{

	@Autowired private UtenteService userService;
	@Autowired private EdificioService buildingService;
	@Autowired private PostazioneService workstationService;
	@Autowired private PrenotazioneService bookingService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("UserRunner...");
		
		System.out.println();
		System.out.println("*** SEZIONE UTENTI ***");
		System.out.println();
		
//		Utente u1 = userService.creaUtenteAdmin();
//		Utente u2 = userService.creaUtenteFake();
//		Utente u3 = userService.creaUtenteFake();
//		Utente u4 = userService.creaUtenteFake();
//		Utente u5 = userService.creaUtente("Emanuele", "Umberto", "EMANUELE.UMBERTO", "ema.umbe@gmail.com");	
//		System.out.println(u1);
//		System.out.println(u2);
//		System.out.println(u3);
//		System.out.println(u4);
//		System.out.println(u5);		
//		userService.insertUser(u1);
//		userService.insertUser(u2);
//		userService.insertUser(u3);
//		userService.insertUser(u4);
//		userService.insertUser(u5);
		
		
		userService.getAll().forEach(u->System.out.println("ID: " + u.getId() + " - " + u.getNome() + 
															" " + u.getCognome() + " (" + u.getUsername() + ")"));
		
		System.out.println();
 		System.out.println("*** SEZIONE EDIFICI ***");
 		System.out.println();
		
//		Edificio e1 = buildingService.creaEdificio("Palazzo Doglio", "Via san Lucifero", 21, "Cagliari");
//		Edificio e2 = buildingService.creaEdificioFake();
//		Edificio e3 = buildingService.creaEdificioFake();	
//		System.out.println(e1);
//		System.out.println(e2);
//		System.out.println(e3);		
//		buildingService.insertBuilding(e1);
//		buildingService.insertBuilding(e2);
//		buildingService.insertBuilding(e3);
		
		buildingService.getAll().forEach(e->System.out.println("ID: " + e.getId() + " - " + e.getNome() + " (" + e.getVia() + 
																", " + e.getCivico() + " - " + e.getCitta() + ")"));

		System.out.println();
		System.out.println("*** SEZIONE POSTAZIONI ***");
		System.out.println();
		
//		Postazione p1 = workstationService.creaPostazioneFake();
//		p1.setEdificio(buildingService.getByID(1));
//		Postazione p2 = workstationService.creaPostazioneFake();
//		p2.setEdificio(buildingService.getByID(2));
//		Postazione p3 = workstationService.creaPostazioneFake();
//		p3.setEdificio(buildingService.getByID(2));
//		Postazione p4 = workstationService.creaPostazioneFake();
//		p4.setEdificio(buildingService.getByID(1));
//		Postazione p5 = workstationService.creaPostazioneFake();
//		p5.setEdificio(buildingService.getByID(3));
//		workstationService.insertWorkstation(p1);
//		workstationService.insertWorkstation(p2);
//		workstationService.insertWorkstation(p3);
//		workstationService.insertWorkstation(p4);
//		workstationService.insertWorkstation(p5);
		
		workstationService.getAll().forEach(w->System.out.println("ID: " + w.getId() + " - " + w.getDescrizione() + " • " + w.getTipo().toString().toLowerCase() + 
																 " • "+ w.getNumeroMassimo() + " persone max (" + w.getEdificio().getNome() + " - " + w.getEdificio().getCitta() + ")"));
		
		
		System.out.println();
		System.out.println("*** SEZIONE PRENOTAZIONI ***");
		System.out.println();
		
		Prenotazione b1 = bookingService.creaPostazioneFake();
		bookingService.insertBooking(b1);
		Prenotazione b2 = bookingService.creaPostazioneFake();
		bookingService.insertBooking(b2);
		Prenotazione b3 = bookingService.creaPostazioneFake();
		bookingService.insertBooking(b3);
		Prenotazione b4 = bookingService.creaPostazioneFake();
		bookingService.insertBooking(b4);
		Prenotazione b5 = bookingService.creaPostazioneFake();
		bookingService.insertBooking(b5);
		Prenotazione b6 = bookingService.creaPostazioneFake();
		bookingService.insertBooking(b6);
		Prenotazione b7 = bookingService.creaPostazioneFake();
		bookingService.insertBooking(b7);
		Prenotazione b8 = bookingService.creaPostazioneFake();
		bookingService.insertBooking(b8);
		
		bookingService.getAll().forEach(b->System.out.println("ID: " + b.getId() + " - " + b.getUtente().getNome() + " " + b.getUtente().getCognome() + " @ " + b.getPostazione().getEdificio().getNome() + " ("+ b.getPostazione().getTipo().toString().toLowerCase() + 
				 ") • "+ b.getPostazione().getNumeroMassimo() + " persone max (" + b.getPostazione().getEdificio().getVia()+ ", "+b.getPostazione().getEdificio().getCivico() + " - " + b.getPostazione().getEdificio().getCitta() + ")"));
		
		System.out.println();
		System.out.println("****************************************************************************************************************************");
		System.out.println();
		
	}
}