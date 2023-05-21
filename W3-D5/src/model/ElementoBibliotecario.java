package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
//@Table(name = "elementi_bibliotecari")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
public abstract class ElementoBibliotecario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String isbn;
	
	@Column(nullable=false)
	private String titolo;
	
	@Column(name="anno_pubblicazione", nullable=false)
	private int annoPubblicazione;
	
	@Column(name="numero_pagine", nullable=false)
	private int numeroPagine;
	 
	public ElementoBibliotecario() {
		super();
	}

	public ElementoBibliotecario(String titolo, int annoPubblicazione, int numeroPagine) {
		super();
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return "ElementoBibliotecario [isbn=" + isbn + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numeroPagine + "]";
	}
	 
	
	 
}
