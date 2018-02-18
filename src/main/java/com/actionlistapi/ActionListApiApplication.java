package com.actionlistapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.actionlistapi.controller.Query;
import com.actionlistapi.repository.KrewItmActnListRepository;

@SpringBootApplication
public class ActionListApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActionListApiApplication.class, args);
	}
	
	@Bean
	public Query query(KrewItmActnListRepository krewItmActnListRepository){
		return new Query(krewItmActnListRepository);
	} 
}
