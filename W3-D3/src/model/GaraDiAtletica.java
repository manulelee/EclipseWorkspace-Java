package model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import utils.TipoEvento;

@Entity
public class GaraDiAtletica extends Evento{
	
	@ManyToMany
	private Set<Persona> atleti;
	
	@ManyToOne
	private Persona vincitore;
	
	public GaraDiAtletica() {
		super();
	}

	public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Set<Partecipazione> setPartecipazioni, Location location, Set<Persona> atleti, Persona vincitore) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, setPartecipazioni, location);
		this.atleti = atleti;
		this.vincitore = vincitore;
	}

	public Set<Persona> getAtleti() {
		return atleti;
	}

	public void setAtleti(Set<Persona> atleti) {
		this.atleti = atleti;
	}

	public Persona getVincitore() {
		return vincitore;
	}

	public void setVincitore(Persona vincitore) {
		this.vincitore = vincitore;
	}

	
	
}
