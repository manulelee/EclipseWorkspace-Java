package com.epicode.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prenotazioni")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate giorno;
	
	@ManyToOne (fetch = FetchType.EAGER)
	private Postazione postazione;
	
	@ManyToOne (fetch = FetchType.EAGER)
	private Utente utente;

	public Prenotazione(LocalDate giorno, Postazione postazione, Utente utente) {
		super();
		this.giorno = giorno;
		this.postazione = postazione;
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "ID: " + id + " • giorno: " + giorno + ", " + postazione.getTipo().toString() + ", utente " + utente.getUsername();
	}
	
	
}
