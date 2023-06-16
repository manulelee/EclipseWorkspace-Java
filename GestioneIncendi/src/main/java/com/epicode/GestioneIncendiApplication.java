package com.epicode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epicode.models.CentroControllo;
import com.epicode.models.Sonda;



@SpringBootApplication
public class GestioneIncendiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneIncendiApplication.class, args);
		
		CentroControllo c= new CentroControllo();
		c.setLuogo("Luogo x");
		c.setNome("Stazione di controllo principale");
		
		Sonda s1 = new Sonda();
		s1.setLat("8892d8782n");
		s1.setLon("8982978223");
		
		s1.addSonda(c);
		
		Sonda s2 = new Sonda();
		s2.setLat("8892d8782n");
		s2.setLon("8982978223");
		
		s2.addSonda(c);
		
		System.out.println(s2.toString());
		
		s1.setSmokeLevel(6);
		
		Sonda s3 = new Sonda();
		s3.setLat("8892d8782n");
		s3.setLon("8982978223");
		
		s3.addSonda(c);
		
		s3.removeSonda(c);
		s3.setSmokeLevel(6);
	}
	
	}


