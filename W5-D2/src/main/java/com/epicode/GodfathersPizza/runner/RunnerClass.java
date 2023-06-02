package com.epicode.GodfathersPizza.runner;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.epicode.GodfathersPizza.configuration.MenuConfiguration;
import com.epicode.GodfathersPizza.configuration.OrderConfigurator;
import com.epicode.GodfathersPizza.model.Menu;
import com.epicode.GodfathersPizza.model.Order;
import com.epicode.GodfathersPizza.model.Table;

@Component
public class RunnerClass implements CommandLineRunner{

	Logger log = LoggerFactory.getLogger(RunnerClass.class);

	@Override
	public void run(String... args) throws Exception {
		System.out.println("I'm a runner!");
		configWith_Bean();
		
		configOrderWith_Bean();
	}
	
	public void configWith_Bean() {
		// Creo un Container dove utilizzare i bean sulla base del file di configurazione ConfigurationTest creato
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		
		// Recupero il Bean Menu
		Menu menu = (Menu) appContext.getBean("menu");
		System.out.println("*************************** Menu ***************************");
		System.out.println("");
		System.out.println("PIZZAS");
		menu.getMenuPizza().forEach(p -> log.info(p.getMenuItemLine()));
		System.out.println("");
		System.out.println("TOPPINGS");
		menu.getMenuTopping().forEach(t -> log.info(t.getMenuItemLine()));
		System.out.println("");
		System.out.println("DRINKS");
		menu.getMenuDrink().forEach(d -> log.info(d.getMenuItemLine()));
		System.out.println("");
		System.out.println("FRANCHISE");
		menu.getMenuFranchise().forEach(o -> log.info(o.getMenuItemLine()));
		
		
		// Chiudo il Context
		appContext.close();
	}	
	
	public void configOrderWith_Bean() {
		// Creo un Container dove utilizzare i bean sulla base del file di configurazione ConfigurationTest creato
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(OrderConfigurator.class);
		
		System.out.println("");
		Table t1 = (Table) appContext.getBean("table", 1,4, true);
		log.info(t1.toString());
		Order o1 = (Order) appContext.getBean("order");
		log.info(o1.toString());
		
		// Chiudo il Context
		appContext.close();
	}
}
