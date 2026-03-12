package com.training.module9;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/*
	 * @Bean
	 * public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
	 * Exception {
	 * http.authorizeHttpRequests(auth -> auth
	 * .requestMatchers("/public/**").permitAll()
	 * .anyRequest().authenticated())
	 * .httpBasic(withDefaults());
	 * return http.build();
	 * }
	 */

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/dashboard/**").hasAnyRole("USER", "MANAGER")
						.requestMatchers("/home/**").hasRole("USER")
						.requestMatchers("/reports/**").hasRole("MANAGER")
						.anyRequest().authenticated())
				.httpBasic(withDefaults());
		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {

		UserDetails dev1 = User.withUsername("dev01")
				.password(passwordEncoder().encode("dev01pwd"))
				.roles("USER")
				.build();
		UserDetails dev2 = User.withUsername("dev02")
				.password(passwordEncoder().encode("dev02pwd"))
				.roles("USER")
				.build();
		UserDetails manager = User.withUsername("manager01")
				.password(passwordEncoder().encode("manager01pwd"))
				.roles("MANAGER")
				.build();
		return new InMemoryUserDetailsManager(dev1, dev2, manager);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
