package com.training.module9.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

	@GetMapping("/profile2")
	public String getProfile2(Principal principal) {
		return "Hello, " + principal.getName();
	}
}
