package com.epicode.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@Column(nullable = false)
	private String password;   
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "utenti_ruoli",
	      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
	      inverseJoinColumns = @JoinColumn(name = "ruolo_id", referencedColumnName = "id")
	    )
	private Set<Ruolo> ruoli = new HashSet<>();
	
	
	@ManyToMany (targetEntity = Prenotazione.class, fetch = FetchType.EAGER)
	@JoinTable (name = "utenti_lista_prenotazioni", 
			joinColumns = @JoinColumn (name= "utente_id"),
			inverseJoinColumns = @JoinColumn(name= "prenotazione_id"))
	@JsonIgnore
	private List<Prenotazione> listaPrenotazioni = new ArrayList<Prenotazione>();

	public Utente(String nome, String cognome, String username, String email) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.email = email;
	}

	
}
