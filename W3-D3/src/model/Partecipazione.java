package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="partecipazioni")
public class Partecipazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column (nullable = false)
	private Persona persona;
	@Column (nullable = false)
	private Evento evento;
	@Enumerated (EnumType.STRING)
	@Column (nullable = false)
	private State stato;
	
	public Partecipazione() {
	}

	public Partecipazione(Persona persona, Evento evento, State stato) {
		super();
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public State getStato() {
		return stato;
	}

	public void setStato(State stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", persona=" + persona + ", evento=" + evento + ", stato=" + stato + "]";
	}
	
	
}

