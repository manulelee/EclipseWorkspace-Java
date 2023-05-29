package com.springboot.configuration;

import java.util.ArrayList;
import java.util.List;

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
public class Pizza {
	
	private String nome;
	private Topping[] ingredienti;
	private double prezzo;
	private int calorie;
	
	public Pizza (Topping[] ingredienti, double prezzo, int calorie) {
		this.nome = null;
		this.ingredienti = ingredienti;
		this.prezzo = prezzo;
		this.calorie = calorie;
	}
	
}
