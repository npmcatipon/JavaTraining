package com.training.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	private LoggerService loggerService;
	
	@Autowired
	public void setLoggerService(LoggerService loggerService) {
		this.loggerService = loggerService;
	}
	
	public void printLog() {
		loggerService.log("Testing");
	}
}
