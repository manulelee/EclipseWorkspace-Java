package com.epicode.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import com.epicode.demo.model.Prenotazione;
import com.epicode.demo.model.Utente;
import com.epicode.demo.service.PostazioneService;
import com.epicode.demo.service.PrenotazioneService;
import com.epicode.demo.service.UtenteService;

@Component
class TestPrenotazioni {
	
	private PostazioneService workstationService = new PostazioneService();
	private PrenotazioneService bookingService = new PrenotazioneService();
	private UtenteService userService = new UtenteService();
	
	List<Prenotazione> a;
	List<Prenotazione> b;
	boolean cond;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		a = bookingService.findByGiornoAndPostazione(LocalDate.of(2023, 06, 06), workstationService.getByID(2));
		System.out.println(a.size());
		Utente u = userService.getByID(2);
		Prenotazione p = bookingService.creaPrenotazione(LocalDate.of(2023, 06, 06), workstationService.getByID(2), u);
		bookingService.insertBooking(p);
		b = bookingService.findByGiornoAndPostazione(LocalDate.of(2023, 06, 06), workstationService.getByID(2));
		System.out.println();
		cond = a.size()==b.size();
	}
	
	@Test
	void testInserimento() {
		
		//Inserimento prenotazione con controllo sulla lista
		assertTrue(cond);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}


}
