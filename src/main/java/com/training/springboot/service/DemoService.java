package com.training.springboot.service;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class DemoService {
	
	private final ApplicationContext context;
	
	public DemoService (ApplicationContext context) {
		this.context = context;
	}

	@PostConstruct
	public void init() {
		SingletonService s1 = 
				context.getBean(SingletonService.class);
		SingletonService s2 = 
				context.getBean(SingletonService.class);
		
		PrototypeService p1 = 
				context.getBean(PrototypeService.class);
		PrototypeService p2 = 
				context.getBean(PrototypeService.class);
		
		System.out.println("Singleton Same? " + (s1 == s2));
		System.out.println("Prototype Same? " + (p1 == p2));
	}
}
