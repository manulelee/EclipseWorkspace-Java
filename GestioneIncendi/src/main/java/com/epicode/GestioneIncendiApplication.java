package com.epicode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epicode.models.CentroControllo;
import com.epicode.models.Sonda;



@SpringBootApplication
public class GestioneIncendiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneIncendiApplication.class, args);
		
		CentroControllo c1= new CentroControllo(1, "Stazione di controllo Roma", "Roma");
		CentroControllo c2= new CentroControllo(1, "Stazione di controllo Milano", "Milano");
		
		Sonda s1 = new Sonda(1, "39.223841", "9.121661");
		Sonda s2 = new Sonda(2, "41.9027835", "12.4963655");
		Sonda s3 = new Sonda(3, "45.4654219", "9.1859243");
		
		s1.addReciver(c1); //Aggiungo la sonda 1 al centro 1
		s2.addReciver(c1); //Aggiungo la sonda 2 al centro 1

		s1.addReciver(c2); //Aggiungo la sonda 1 al centro 2
		
		s1.setSmokeLevel(6); // Verranno richiamate c1 e c2
		s2.setSmokeLevel(4); // Non verrà richiamata c2 perchè il livello è inferiore a 5
		s3.setSmokeLevel(4); // s3 non è collegata a nessun cetro di controllo
		
	}
	
	}


