package com.training.module8.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.module8.model.Book;


@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private static final List<Book> books = List.of(
			new Book(1L,"Java 101","Author of Java 101"),
			new Book(2L,"Java 102","Author of Java 102"),
			new Book(3L,"Java 103","Author of Java 103")
			);

	@GetMapping
	public List<Book> getAll() {
		return books;
	}

	
	
}
