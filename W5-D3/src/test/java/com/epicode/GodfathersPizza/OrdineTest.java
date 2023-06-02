package com.epicode.GodfathersPizza;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epicode.GodfathersPizza.model.Tavolo;
import com.epicode.GodfathersPizza.model.DrinkLemonade;
import com.epicode.GodfathersPizza.model.DrinkWater;
import com.epicode.GodfathersPizza.model.Ordine;
import com.epicode.GodfathersPizza.model.PizzaMargherita;
import com.epicode.GodfathersPizza.model.PizzaSalami;
import com.epicode.GodfathersPizza.model.StatoOrdine;

class OrdineTest {
	
	Tavolo t;
	Ordine o;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("--- Test Ordine ---");
	}

	@BeforeEach
	void setUp() throws Exception {
		t = new Tavolo(1, 4);
		o = new Ordine(1, t, 3, 1);
		o.getOrdinato().add(new PizzaMargherita());
		o.getOrdinato().add(new PizzaSalami());
		o.getOrdinato().add(new DrinkLemonade());
		o.getOrdinato().add(new DrinkWater());
	}

	@Test
	void testOrdine() {
		assertTrue(o != null);
		System.out.println("testOrdine: " + true);
	}

	@Test
	void testGetTotale() {
		assertEquals(17.059999999999999, o.getTotale());
		System.out.println("testGetTotale: " + true);
	}

	@Test
	void testGetNumeroOrdine() {
		assertTrue(o.getNumeroOrdine()==1);
		System.out.println("testGetNewTavolo: " + true);
	}

	@Test
	void testGetNewTavolo() {
		t = new Tavolo(1, 4);
		assertFalse( t.isOccupato());
		System.out.println("testGetNewTavolo: " + t.isOccupato());
	}
	
	@Test
	void testGetTavoloOrdine() {
		assertTrue(t.isOccupato());
		System.out.println("testGetTavoloOrdine: " + t.isOccupato());
	}

	@Test
	void testGetStato() {
		assertTrue(o.getStato().equals(StatoOrdine.IN_CORSO));
		System.out.println("testGetStato: " + true );
	}

	@Test
	void testGetNumeroCoperti() {
		t.setNumeroCoperti(2);
		o.setNumeroCoperti(2);
		assertTrue(t.getNumeroCoperti() >= o.getNumeroCoperti());
		System.out.println("testGetNumeroCoperti: " + true );
	}
	
	@AfterEach
	void tearDown() throws Exception {
		t = null;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("--- Fine Test Ordine ---");
	}

}
