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
public class Merchandising {
	
	private String nome;
	private double prezzo;
	
	@Override
	public String toString() {
		return "Merch - " + nome + ", prezzo: " + prezzo +"€";
	}
	
	
}
