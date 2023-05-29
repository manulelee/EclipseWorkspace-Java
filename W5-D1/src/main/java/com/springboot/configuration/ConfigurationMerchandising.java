package com.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationMerchandising {

	@Bean
	@Scope("prototype")
	public Merchandising merchandising (String nome, double prezzo) {
		return new Merchandising(nome, prezzo);
	}
	
	
}
