package com.weeklyProject;
import java.time.LocalDate;

public class Rivista extends ElementoBibliotecario{

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + "]";
	}

	Periodicità periodicita;

	public Rivista(long isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine, Periodicità periodicita) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	public Periodicità getPeriodicita() {
		return periodicita;
	}
	
}
