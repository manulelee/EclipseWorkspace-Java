package com.springboot.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Drink {

	private String nome;
	private int calorie;
	private double prezzo;
	private double formato;
	private int volumi;
	
	public Drink (String nome, int calorie, double prezzo, double formato) {
		this.nome = nome;
		this.calorie = calorie;
		this.prezzo= prezzo;
		this.formato= formato;
	}
}
