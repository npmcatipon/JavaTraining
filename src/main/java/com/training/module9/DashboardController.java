package com.training.module9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class DashboardController {

	@GetMapping("/home")
	public String user() {
		return "Dashboard for User";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "Welcome to the portal";
	}

	@GetMapping("/reports")
	public String admin() {
		return "Manager Reports";
	}
}
