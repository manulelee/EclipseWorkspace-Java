package model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="eventi")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column (nullable = false)
	private String titolo;
	@Column (name="data_evento", nullable = false)
	private LocalDate dataEvento;
	@Column (nullable = false)
	private String descrizione;
	@Column (name="tipo_evento", nullable = false)
	@Enumerated (EnumType.STRING)
	private TipoEvento tipoEvento;
	@Column (name="max_partecipanti", nullable = false)
	private Integer maxPartecipanti;
	@Column (nullable = false)
	private Set<Partecipazione> partecipazioni;
	@Column (nullable = false)
	@OneToOne
	private Location location;
	
	
	public Evento() {
	}

	public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer maxPartecipanti, Set<Partecipazione> partecipazioni, Location location) {
		super();
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.maxPartecipanti = maxPartecipanti;
		this.partecipazioni = partecipazioni;
		this.location = location;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Integer getMaxPartecipanti() {
		return maxPartecipanti;
	}

	public void setMaxPartecipanti(Integer maxPartecipanti) {
		this.maxPartecipanti = maxPartecipanti;
	}

	public Set<Partecipazione> getPartecipazioni() {
		return partecipazioni;
	}

	public void setPartecipazioni(Set<Partecipazione> partecipazioni) {
		this.partecipazioni = partecipazioni;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoEvento + ", maxPartecipanti=" + maxPartecipanti + ", partecipazioni="
				+ partecipazioni + ", location=" + location + "]";
	}


}
