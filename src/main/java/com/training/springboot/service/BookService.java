package com.training.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private LoggerService loggerService;
		
	public void printLog() {
		loggerService.log("Activity 4");
	}
}
