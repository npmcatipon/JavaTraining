package com.training.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	private final LoggerService loggerService;
	
	public BookService (LoggerService loggerService) {
		this.loggerService = loggerService;
	}
	
	public void log() {
		loggerService.log("Test");
	}
}
