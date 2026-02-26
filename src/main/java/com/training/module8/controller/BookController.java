package com.training.module8.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.module8.model.Book;
import com.training.module8.service.BookService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final BookService service;
	
	public BookController(BookService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(book));
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAll(
			@RequestParam(required =false) Long id) {
		List <Book> books = (id != null)
				? service.searchById(id)
				: service.getAll();
		return ResponseEntity.ok(books);
	}
	
}
