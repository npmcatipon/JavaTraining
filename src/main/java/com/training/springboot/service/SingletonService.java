package com.training.springboot.service;

import org.springframework.stereotype.Component;

@Component
public class SingletonService {
	
	public void print() {
		System.out.println("SingletonService Created");
	}

}
