package com.epicode.demo.runner;

import java.time.LocalDate;
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
		Faker fake = Faker.instance(new Locale("it-IT"));
		
		System.out.println("UserRunner...");
		
		System.out.println();
		System.out.println("*** SEZIONE UTENTI ***");
		System.out.println();
		
// 		//Inserimento untente admin
//		Utente u1 = userService.creaUtenteAdmin();
//		userService.insertUser(u1);
//		
// 		//Inserimento untente custom
//		Utente u2 = userService.creaUtente("Emanuele", "Umberto", "EMANUELE.UMBERTO", "ema.umbe@gmail.com");
//		userService.insertUser(u2);
//	
// 		//Inserimento di n utenti fake
//		
//		for(int i=0;  i<8; i++) {
//			Utente u = userService.creaUtenteFake();
//			userService.insertUser(u);
//		}
		
		userService.getAll().forEach(u->System.out.println("ID: " + u.getId() + " - " + u.getNome() + 
															" " + u.getCognome() + " (" + u.getUsername() + ")"));
		
		System.out.println();
 		System.out.println("*** SEZIONE EDIFICI ***");
 		System.out.println();
 		
// 		//Inserimento edificio custom
// 		Edificio e1 = buildingService.creaEdificio("Palazzo Doglio", "Via san Lucifero", 21, "Cagliari");
// 		buildingService.insertBuilding(e1);
//		
// 		//Inserimento di 3 edifici
//		for(int i=0;  i<3; i++) {
//			Edificio e = buildingService.creaEdificioFake();
//			buildingService.insertBuilding(e);
//		}
 	
		buildingService.getAll().forEach(e->System.out.println("ID: " + e.getId() + " - " + e.getNome() + " (" + e.getVia() + 
																", " + e.getCivico() + " - " + e.getCitta() + ")"));

		System.out.println();
		System.out.println("*** SEZIONE POSTAZIONI ***");
		System.out.println();
		
//		//Inserimento di 5 postazioni
//		
//		for(int i=0;  i<5; i++) {
//			int buildingID = fake.random().nextInt(1,buildingService.getAll().size());
//			Postazione p = workstationService.creaPostazioneFake();
//			p.setEdificio(buildingService.getByID(buildingID));
//			workstationService.insertWorkstation(p);
//		}
		
		workstationService.getAll().forEach(w->System.out.println("ID: " + w.getId() + " - " + w.getDescrizione() + " • " + w.getTipo().toString().toLowerCase() + 
																 " • "+ w.getNumeroMassimo() + " persone max (" + w.getEdificio().getNome() + " - " + w.getEdificio().getCitta() + ")"));
		
		
		System.out.println();
		System.out.println("*** SEZIONE PRENOTAZIONI ***");
		System.out.println();
		
	
//		//Inserimento di 20 prenotazioni con controllo sulla lista
//		
//		for(int i=0;  i<5; i++) {
//			Prenotazione b = bookingService.creaPrenotazioneFake();
//			bookingService.insertBooking(b);
//		}		
	
		bookingService.getAll().forEach(b->System.out.println("ID: " + b.getId() + " - " + b.getUtente().getNome() + " " + b.getUtente().getCognome() + " @ " + b.getPostazione().getDescrizione() + " ("+ b.getPostazione().getTipo().toString().toLowerCase() + 
				 ") " + b.getGiorno() +" • "+ b.getPostazione().getNumeroMassimo() + " persone max (" + b.getPostazione().getEdificio().getVia()+ ", "+b.getPostazione().getEdificio().getCivico() + " - " + b.getPostazione().getEdificio().getCitta() + ")"));
	
		System.out.println();
		System.out.println("***********************************************************************************************************************************************************");
		System.out.println();
		
		
	}
}