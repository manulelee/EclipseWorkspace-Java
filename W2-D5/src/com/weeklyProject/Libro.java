package com.weeklyProject;
import java.time.LocalDate;

public class Libro extends ElementoBibliotecario{
	
	private String autore;
	private String genere;
	
	public Libro(long isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine, String autore,
			String genere) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}
	public String getAutore() {
		return autore;
	}


	public String getGenere() {
		return genere;
	}
	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + "]";
	}	


}
