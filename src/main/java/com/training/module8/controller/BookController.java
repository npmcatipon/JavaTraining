package com.training.module8.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.module8.model.Book;


@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final List<Book> books = new ArrayList<>( 
			List.of(
			new Book(1L,"Java 101"),
			new Book(2L,"Java 102"),
			new Book(3L,"Java 103")
			));
	
	private int bookcount = 4;

	// Implementing GET 8.1
	@GetMapping
	public List<Book> getAll() {
		return books;
	}
	
	// Implementing @PathVariable 8.3
	@GetMapping("/{id}")
	public Book getOne(@PathVariable Long id) {
		return books.stream()
				.filter(b -> b.getId().equals(id))
				.findFirst()
				.orElse(null);
	}

	// Implementing POST 8.2
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Book create(@RequestBody Book book) {
		book.setId(Long.valueOf(bookcount));
		books.add(book);
		bookcount++;
		return book;
	}
	
}
