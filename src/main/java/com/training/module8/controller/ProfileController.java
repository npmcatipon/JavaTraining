package com.training.module8.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class ProfileController {
	
	@Value("${app.msg}")
	private String message;
	
	@GetMapping
	public String displayWelcomeMessage() {
		return message;
	}
}
