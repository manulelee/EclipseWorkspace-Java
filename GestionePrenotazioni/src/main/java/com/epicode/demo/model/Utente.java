package com.epicode.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="utenti")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Utente {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column (nullable=false)
	private String nome;
	
	@Column (nullable=false)
	private String cognome;
	
	@Column (unique = true, nullable = false)
	private String username;
	
	@Column (unique = true, nullable = false)
	private String email;
	
	@ManyToMany
	@JoinColumn (name = "lista_prenotazioni")
	private List<Prenotazione> listaPrenotazioni = new ArrayList<Prenotazione>();

	public Utente(String nome, String cognome, String username, String email) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.email = email;
	}

	
}
