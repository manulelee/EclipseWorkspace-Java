package com.epicode.demo.configurator;


import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.demo.model.Edificio;
import com.github.javafaker.Address;
import com.github.javafaker.Faker;

@Configuration
public class EdificioConfiguration {
	
	@Bean("EdificioFakeBean")
	@Scope("prototype")
	public Edificio fake() {
		
		Faker fake = Faker.instance(new Locale("it-IT"));
		Address address = fake.address();
		String citta = address.city();
		String via = address.streetName();
		int civico = Integer.parseInt(address.streetAddressNumber());
		String nome = fake.twinPeaks().location() + " building";
		Edificio buildingFake = new Edificio(nome,via, civico, citta);
		return buildingFake;
	}
	
	@Bean("EdificioBean")
	@Scope("prototype")
	public Edificio custom(String nome, String via, int civico, String citta) {
		return new Edificio(nome, via, civico, citta);
	}
	
}
