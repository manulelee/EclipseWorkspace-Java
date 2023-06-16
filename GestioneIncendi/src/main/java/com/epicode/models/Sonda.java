package com.epicode.models;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
//@Entity
//@Table(name="sonde")
public class Sonda implements Subject{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String lat;
	
	@Column(nullable=false)
	private String lon;
	
	
	private Integer smokeLevel = 0;
	
	private List<Observer> stazioneControllo = new ArrayList<Observer>();

	
	public void setSmokeLevel(Integer l) {
		this.smokeLevel=l;
		if (smokeLevel>5) {
			this.notify( "La sonda :" + this.lon + "ha registrato un livello pari a " + this.smokeLevel);
		}
	
	}

	@Override
	public void addSonda(Observer o) {
		// TODO Auto-generated method stub
		stazioneControllo.add(o);
		System.out.println("Sonda aggiunta alla stazione di controllo");
	}


	@Override
	public void removeSonda(Observer o) {
		// TODO Auto-generated method stub
		stazioneControllo.remove(o);
		System.out.println("Sonda rimossa dalla stazione di controllo");
	}


	@Override
	public void notify(String message) {
		// TODO Auto-generated method stub
		stazioneControllo.forEach(o-> o.update("Sonda " + this.id + ":" + message));
	}
	
}
