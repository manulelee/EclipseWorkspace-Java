package com.epicode.GodfathersPizza.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@PropertySource("classpath:application.properties")
public class Order {
	@Value("${tavolo.coperto.costo}") private String costoCoperto;

	private int id;
	private Table tavolo;
	private List<FoodItem> prodotti = new ArrayList<FoodItem>();
	private StatoOrdine stato = StatoOrdine.IN_CORSO;
	private int coperti = 1;
	private String note;
	private LocalTime ora= LocalTime.now();
	private double totale; //= calcoloTotale();
	
	public double calcoloTotale () {
		double t = 0;
		
		FoodItem[] p = (FoodItem[]) this.prodotti.toArray();
		for (int i =0; i<p.length; i++ ) {
			t = t + p[i].price;
		}
		
		t += Integer.parseInt(costoCoperto) * coperti;
		return t;	
	}
	
	
	
}
