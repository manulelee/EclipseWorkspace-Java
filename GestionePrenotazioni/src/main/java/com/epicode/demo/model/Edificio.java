package com.epicode.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "edifici")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (nullable = false)
	private String nome;
	
	@Column (nullable = false)
	private String via;
	
	@Column (nullable = false)
	private int civico;
	
	@Column (nullable = false)
	private String citta;

	public Edificio(String nome, String via, int civico, String citta) {
		super();
		this.nome = nome;
		this.via = via;
		this.civico = civico;
		this.citta = citta;
	}
}
