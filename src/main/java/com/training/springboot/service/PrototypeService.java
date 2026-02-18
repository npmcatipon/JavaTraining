package com.training.springboot.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeService {
	
	public void print() {
		System.out.println("PrototypeService Created");
	}

}
