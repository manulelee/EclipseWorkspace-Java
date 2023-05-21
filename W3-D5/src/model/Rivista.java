package model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import utils.Periodicità;

@Entity
@Table(name = "riviste")
public class Rivista extends ElementoBibliotecario{

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	Periodicità periodicita;

	public Rivista() {
		super();
	}

	public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicita) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	public Periodicità getPeriodicita() {
		return periodicita;
	}
	@Override
	public String toString() {
		return "Rivista ISBN:" + super.getIsbn() + ", titolo: " + super.getTitolo() + ", anno di pubblicazione: " + super.getAnnoPubblicazione()
				+ ", numero di pagine: " + super.getNumeroPagine() + ", periodicità: " + periodicita;
	} 
}
