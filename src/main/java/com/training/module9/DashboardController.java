package com.training.module9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class DashboardController {

	@GetMapping("/dashboard")
	public String dashboard() {
		return "Welcome.";
	}

	@GetMapping("/secured/dashboard")
	public String securedDashboard() {
		return "Welcome to secured dashboard.";
	}

	@GetMapping("/home")
	public String user() {
		return "Dashboard for User.";
	}

	@GetMapping("/reports")
	public String admin() {
		return "Manager Reports.";
	}
}

