package model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import utils.Periodicità;

@Entity
@DiscriminatorValue("Rivista")
public class Rivista extends ElementoBibliotecario{

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
