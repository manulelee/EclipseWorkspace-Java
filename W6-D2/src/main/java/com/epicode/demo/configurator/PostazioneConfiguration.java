package com.epicode.demo.configurator;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.demo.model.Postazione;
import com.epicode.demo.model.TipoPostazione;
import com.github.javafaker.Faker;

@Configuration
public class PostazioneConfiguration {
	
	@Bean("PostazioneFakeBean")
	@Scope("prototype")
	public Postazione fake() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		String description = fake.company().profession() + "'s office";
		int numeroMax =  fake.random().nextInt(1, 10);
		Postazione postazioneFake = new Postazione(description, numeroMax>3 & numeroMax<6 ? TipoPostazione.OPENSPACE : 
																numeroMax<3?TipoPostazione.PRIVATO : TipoPostazione.SALA_RIUNIONI, numeroMax);
		return postazioneFake;
	}
	
	@Bean("PostazioneBean")
	@Scope("prototype")
	public Postazione custom(String descrizione, TipoPostazione tipo, int numeroMassimo) {
		return new Postazione(descrizione, tipo, numeroMassimo);
	}

}
