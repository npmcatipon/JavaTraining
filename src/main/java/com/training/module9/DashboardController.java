package com.training.module9;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DashboardController {

	@GetMapping("/home")
	public String user() {
		return "Welcome to the portal";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "User Dashboard";
	}

	@GetMapping("/reports")
	public String admin() {
		return "Manager Reports";
	}

	@GetMapping("/profile/username/{username}")
	@PreAuthorize("#username == authentication.name")
	public String getProfileByUserName(@PathVariable String username) {
		return "Profile of " + username;
	}
}
