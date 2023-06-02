package com.epicode.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "postazioni")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Postazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (nullable=false)
	private String descrizione;
	
	@Column (nullable=false)
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	
	@Column (nullable=false, name = "numero_massimo")
	private int numeroMassimo;
	
	@OneToMany (mappedBy = "postazione")
	private List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	
	@ManyToOne
	private Edificio edificio;

	public Postazione(String descrizione, TipoPostazione tipo, int numeroMassimo) {
		super();
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.numeroMassimo = numeroMassimo;
	}
	

}
