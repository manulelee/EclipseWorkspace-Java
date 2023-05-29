package com.springboot.W5D1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springboot.configuration.ConfigurationDrink;
import com.springboot.configuration.ConfigurationMerchandising;
import com.springboot.configuration.ConfigurationPizza;
import com.springboot.configuration.ConfigurationTopping;
import com.springboot.configuration.Drink;
import com.springboot.configuration.Merchandising;
import com.springboot.configuration.Pizza;
import com.springboot.configuration.Topping;

@SpringBootApplication
public class W5D1Application {

	public static void main(String[] args) {
		SpringApplication.run(W5D1Application.class, args);
		
		//MAIN
		
		System.out.println("I nostri prodotti:");
		configToppings();
		System.out.println("************************************************************************************");
		configPizza();
		System.out.println("************************************************************************************");
		configDrink();
		System.out.println("************************************************************************************");
		configMerch();
	}
	
	public static void configToppings () {
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationTopping.class);
		
		Topping t1 = (Topping) appContext.getBean("topping", "Mozzarella", 92, 0.69);
		System.out.println(t1);
		
		Topping t2 = (Topping) appContext.getBean("topping", "Prosciutto", 35, 0.99);
		System.out.println(t2);
		
		Topping t3 = (Topping) appContext.getBean("topping", "Cipolle", 22, 0.69);
		System.out.println(t3);
		
		Topping t4 = (Topping) appContext.getBean("topping", "Ananas", 24, 0.79);
		System.out.println(t4);
		
		Topping t5 = (Topping) appContext.getBean("topping", "Salame", 86, 0.99);
		System.out.println(t5);
		
		appContext.close();
	}
	
	public static void configPizza () {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationPizza.class);
		
		
		//Creazione pizza margerita (senza parametri)
		Pizza p1 = (Pizza) appContext.getBean("margherita");
		System.out.println(p1);
		
		Topping mozzarella = new Topping("mozzarella", 92,0.69);
		Topping prosciutto = new Topping ("prosciutto", 35, 0.99);
		Topping cipolle = new Topping ("cipolle", 22, 0.69);
		Topping ananas = new Topping ("ananas", 24, 0.79);
		Topping salame = new Topping ("salame", 86, 0.99);
		
		
		//Creazione pizza Hawaiian
		Pizza p2 = (Pizza) appContext.getBean("namedPizza", "Hawaiiana", new Topping [] {new Topping("pomodoro", 0,0.0), new Topping("mozzarella", 92,0.0), ananas, prosciutto}, 6.49, 1024);
		System.out.println(p2);
		
		//Creazione pizza Salame
		Pizza p3 = (Pizza) appContext.getBean("namedPizza", "Salame", new Topping [] {new Topping("pomodoro", 0,0.0), new Topping("mozzarella", 92,0.0), salame}, 5.99, 1160);
		System.out.println(p3);
		
		//Creazione pizza Salame
		Pizza p4 = (Pizza) appContext.getBean("pizza", new Topping [] {new Topping("pomodoro", 0,0.0), new Topping("mozzarella", 92,0.0), prosciutto, salame, cipolle}, 5.99, 1160);
		System.out.println(p4);
				
		
	}
	
	public static void configDrink () {
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationDrink.class);
		
		Drink d1 = (Drink) appContext.getBean("drink", "Acqua", 0, 1.29, 0.5);
		System.out.println(d1);
		
		Drink d2 = (Drink) appContext.getBean("drink", "Limonata", 0, 1.29, 128);
		System.out.println(d2);
		
		Drink d3 = (Drink) appContext.getBean("alcolicDrink", "Vino", 0, 7.49, 607, 13);
		System.out.println(d3);
		
		appContext.close();
	}
	
	public static void configMerch () {
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationMerchandising.class);
		
		Merchandising m1 = (Merchandising) appContext.getBean("merchandising", "Maglietta", 21.99);
		System.out.println(m1);
		
		Merchandising m2 = (Merchandising) appContext.getBean("merchandising", "Tazza", 4.99);
		System.out.println(m2);
		
		appContext.close();
	}
}
