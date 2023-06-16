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
//@Entity
//@Table(name="sonde")
public class Sonda implements Subject{

	private Integer id;
	private String lat;
	private String lon;
	private Integer smokeLevel = 0;
	private List<Observer> stazioniControllo = new ArrayList<Observer>();
	
	public Sonda(Integer id, String lat, String lon) {
		super();
		this.id = id;
		this.lat = lat;
		this.lon = lon;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	public String getLat() {
		return this.lat;
	}
	
	public void setLon(String lon) {
		this.lon = lon;
	}
	
	public String getLon() {
		return this.lon;
	}

	public Integer getSmokeLevel() {
		return this.smokeLevel;
	}
	
	public void setSmokeLevel(Integer n) {
		this.smokeLevel=n;
		if (smokeLevel>5) {
			this.notify( "La sonda " + this.id + " ha registrato un livello pari a " + this.smokeLevel);
		}
	
	}

	@Override
	public void addReciver(Observer o) {
		// TODO Auto-generated method stub
		stazioniControllo.add(o);
		System.out.println("Sonda " + this.id + " aggiunta alla stazione di controllo");
	}


	@Override
	public void removeReciver(Observer o) {
		// TODO Auto-generated method stub
		stazioniControllo.remove(o);
		System.out.println("Sonda " + this.id + " rimossa dalla stazione di controllo");
	}


	@Override
	public void notify(String message) {
		// TODO Auto-generated method stub
		// stazioniControllo.forEach(o-> o.update("Centro di controllo: " + message));
		for (Observer o : stazioniControllo) {
			o.update(((CentroControllo)o).getNome() +" - " + message);
		}
	}

	
}
