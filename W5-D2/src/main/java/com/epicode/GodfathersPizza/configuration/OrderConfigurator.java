package com.epicode.GodfathersPizza.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.GodfathersPizza.model.Order;
import com.epicode.GodfathersPizza.model.Table;


@Configuration

public class OrderConfigurator {
	
	@Bean
	@Scope("prototype")
	public Table table (int id, int numeroMax, boolean disponibile) {
		return new Table(id, numeroMax, disponibile);
	}
	
	@Bean
	@Scope("prototype")
	public Order order (){
		return new Order();
	}

	}
