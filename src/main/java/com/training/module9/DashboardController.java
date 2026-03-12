package com.training.module9;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
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

	@GetMapping("/profile/username/{username}")
	@PreAuthorize("#username == authentication.name")
	public String getProfileByUserName(@PathVariable String username) {
		return "Profile of " + username;
	}

	@GetMapping("/whoami")
	public String whoAmI(Authentication auth) {
		return auth.getName();
	}
}
