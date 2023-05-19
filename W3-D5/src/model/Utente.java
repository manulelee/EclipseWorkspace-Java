package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity 
@Table(name="utenti")
public class Utente {
	
	private String nome;
	private String cognome;
	@Column(name="data_nascita")
	private LocalDate dataNascita;
	@Id
	@SequenceGenerator(name="tessera2023_0", sequenceName="tessera2023_0", initialValue =0, allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tessera2023_0")
	@Column(name="numero_tessera")
	private String numeroTessera;
	
	
	public Utente() {
		super();
	}


	public Utente(String nome, String cognome, LocalDate dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public LocalDate getDataNascita() {
		return dataNascita;
	}


	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}


	public String getNumeroTessera() {
		return numeroTessera;
	}


	public void setNumeroTessera(String numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", numeroTessera="
				+ numeroTessera + "]";
	}
	
}
