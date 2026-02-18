package com.training.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.training.springboot.service.BookService;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	

    @Bean
    CommandLineRunner run(BookService bookService) {
        return args -> {
            bookService.printLog();   // prints "Test" on startup
        };
    }


}
