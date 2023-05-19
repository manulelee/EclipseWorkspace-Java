package model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import utils.TipoEvento;


@Entity
public class PartitaDiCalcio extends Evento {

	
	private String squadraCasa;
	private String squadraOspite;
	private String squadraVincente = null;
	private Integer golSquadraCasa=0;
	private Integer golSquadraOspite=0;
	
	public PartitaDiCalcio() {
		super();
	}

	public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,Integer numeroMassimoPartecipanti, Set<Partecipazione> setPartecipazioni, Location location,
			String squadraCasa, String squadraOspite, String squadraVincente, Integer golSquadraCasa, Integer golSquadraOspite) {
		
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti,setPartecipazioni, location);
		this.squadraCasa = squadraCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.golSquadraCasa = golSquadraCasa;
		this.golSquadraOspite = golSquadraOspite;
	}

	public String getSquadraCasa() {
		return squadraCasa;
	}

	public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa = squadraCasa;
	}

	public String getSquadraOspite() {
		return squadraOspite;
	}

	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public String getSquadraVincente() {
		return squadraVincente;
	}

	public void setSquadraVincente(String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}

	public Integer getGolSquadraCasa() {
		return golSquadraCasa;
	}

	public void setGolSquadraCasa(Integer golSquadraCasa) {
		this.golSquadraCasa = golSquadraCasa;
	}

	public Integer getGolSquadraOspite() {
		return golSquadraOspite;
	}

	public void setGolSquadraOspite(Integer golSquadraOspite) {
		this.golSquadraOspite = golSquadraOspite;
	}
	
	
	
}
