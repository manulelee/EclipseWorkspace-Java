package com.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationTopping {

	@Bean
	@Scope("prototype")
	public Topping topping (String nome, int calorie, double prezzo) {
		return new Topping (nome, calorie, prezzo);
	}
}
