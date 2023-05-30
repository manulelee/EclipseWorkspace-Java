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
public class Topping {

	private String nome;
	private int calorie;
	private double prezzo;
	@Override
	public String toString() {
		return nome + ", calorie:" + calorie + ", prezzo:" + prezzo + "€";
	}
	
	
}
