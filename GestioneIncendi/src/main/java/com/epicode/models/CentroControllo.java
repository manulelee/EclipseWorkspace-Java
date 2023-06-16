package com.epicode.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
//@Entity
//@Table(name="centro_controllo")
public class CentroControllo implements Observer {

	private Integer id;
	private String nome;
	private String luogo;

	@Override
	public void update( String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}
}
