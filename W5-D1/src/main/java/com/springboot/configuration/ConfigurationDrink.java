package com.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationDrink {

	@Bean
	@Scope("prototype")
	public Drink drink(String nome, int calorie, double prezzo, double formato) {
		return new Drink(nome, calorie, prezzo, formato);
	}
	
	@Bean
	@Scope("prototype")
	public Drink alcolicDrink(String nome, int calorie, double prezzo, double formato, int volumi) {
		return new Drink(nome, calorie, prezzo, formato, volumi);
	}
	
	
}
