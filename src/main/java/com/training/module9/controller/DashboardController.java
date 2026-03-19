package com.training.module9.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && auth.isAuthenticated()) {
			String uname = auth.getName();
			Object principal = auth.getPrincipal();
			Collection<? extends GrantedAuthority> roles = auth.getAuthorities();

			System.out.println("username: " + uname);
			System.out.println("principal: " + principal);
			System.out.println("roles: " + roles);
		}

		return "Profile of " + username;
	}
}
