package com.weeklyProject;
import java.time.LocalDate;

public abstract class ElementoBibliotecario {
	
 private long isbn;
 private String titolo;
 private LocalDate annoPubblicazione;
 private int numeroPagine;
 
 public ElementoBibliotecario(long isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine) {
	this.isbn = isbn;
	this.titolo = titolo;
	this.annoPubblicazione = annoPubblicazione;
	this.numeroPagine = numeroPagine;
}

public long getIsbn() {
	return isbn;
}

public String getTitolo() {
	return titolo;
}

public LocalDate getAnnoPubblicazione() {
	return annoPubblicazione;
}


public int getNumeroPagine() {
	return numeroPagine;
}

@Override
public String toString() {
	return "ElementoBibliotecario [isbn=" + isbn + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
			+ ", numeroPagine=" + numeroPagine + "]";
} 
 
}
