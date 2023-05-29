package com.springboot.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationPizza {
	
	@Bean
	@Scope("singleton")
	public Pizza margherita () {
		return new Pizza ("Margerita", new Topping [] {new Topping("pomodoro", 0,0.0), new Topping("mozzarlla", 92,0.0)}, 4.99, 1104);
	}
	
	@Bean
	@Scope("prototype")
	public Pizza pizza (Topping [] ingredienti, double prezzo, int calorie) {
		return new Pizza (ingredienti, prezzo, calorie);
	}
	
	@Bean
	@Scope("prototype")
	public Pizza namedPizza (String nome, Topping [] ingredienti, double prezzo, int calorie) {
		return new Pizza (nome, ingredienti, prezzo, calorie);
	}
}
