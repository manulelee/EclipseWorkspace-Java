package com.epicode.GodfathersPizza.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.epicode.GodfathersPizza.configuration.MenuConfiguration;
import com.epicode.GodfathersPizza.model.Menu;

@Component
public class RunnerClass implements CommandLineRunner{

	Logger log = LoggerFactory.getLogger(RunnerClass.class);

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run...");
		configWith_Bean();
	}
	public void configWith_Bean() {
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
