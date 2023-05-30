package com.springboot.configuration;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

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
	
	public List <String> showIngredients(Topping[] ingredients) {
		List <String> ingredienti = new ArrayList<String>();
		for (int i =0; i< ingredients.length; i++) {
			ingredienti.add(ingredients[i].getNome());
		}
		return ingredienti;
	}
	
	public int totalCal (Topping[] ingredients) {
		int cal = 1104;
		for (int i =0; i< ingredients.length; i++) {
			cal += ingredients[i].getCalorie();
		}
		return cal;
	}
	
	public double totalPrice (Topping[] ingredients) {
		double price = 4.99;
		for (int i =0; i< ingredients.length; i++) {
			price += ingredients[i].getPrezzo();
		}
		return price;
	}

	@Override
	public String toString() {
		return "Pizza "+ (nome != null? nome + ", " : "- ")+ "ingredienti: " + showIngredients(ingredienti).toString() + ", prezzo: " + prezzo
				+ "€, calorie: " + totalCal(ingredienti) + "";
	}
	
}
