package com.training.module8.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.module8.model.Book;
import com.training.module8.repository.BookRepository;

import jakarta.validation.Valid;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	List<Book> books = new ArrayList<>();
	
	public BookService (BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book create(@Valid Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> getAll() {
		return bookRepository.findAll();
		
	}
	
	public List<Book> searchById(Long id) {
		return bookRepository.findById(id).stream().toList();
	}

}
