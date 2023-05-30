package com.epicode.GodfathersPizza;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.GodfathersPizza.configuration.MenuConfiguration;
import com.epicode.GodfathersPizza.model.Menu;
import com.epicode.GodfathersPizza.runner.RunnerClass;

@SpringBootApplication
public class GodfathersPizzaApplication {
	
	public static Logger log = LoggerFactory.getLogger(RunnerClass.class);

	public static void main(String[] args) {
		SpringApplication.run(GodfathersPizzaApplication.class, args);
		
	}
	
	public static void configWith_Bean() {
		// Creo un Container dove utilizzare i bean sulla base del file di configurazione ConfigurationTest creato
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		
		// Recupero il Bean Menu
		Menu menu = (Menu) appContext.getBean("menu");
		System.out.println("******* Menu *******");
		System.out.println("PIZZAS");
		menu.getMenuPizza().forEach(p -> log.info(p.getMenuItemLine()));
		System.out.println("TOPPINGS");
		menu.getMenuTopping().forEach(t -> log.info(t.getMenuItemLine()));
		System.out.println("DRINKS");
		menu.getMenuDrink().forEach(d -> log.info(d.getMenuItemLine()));
		System.out.println("FRANCHISE");
		menu.getMenuFranchise().forEach(o -> log.info(o.getMenuItemLine()));
		
		// Chiudo il Context
		appContext.close();
	}	

}
