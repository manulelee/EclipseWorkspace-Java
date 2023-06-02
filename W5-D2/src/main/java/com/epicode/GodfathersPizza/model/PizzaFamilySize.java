package com.epicode.GodfathersPizza.model;

import java.text.DecimalFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class PizzaFamilySize extends Pizza  {
	
	DecimalFormat f = new DecimalFormat("##.00");
    
	private Pizza pizza;
	private String name;
	private double calories;
	private double price;

	public PizzaFamilySize(Pizza pizza) {
		super();
		this.name = "Family Size " + pizza.name;
		this.price = pizza.price + 4.15;
		this.calories = pizza.calories * 1.95;
		this.pizza = pizza;
	}
	
	public String getMenuItemLine() {
		return this.name + " - calories: " + f.format(this.calories) + " - price: " + this.price;
	}

}
