package com.training.module8.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.module8.dto.BookDTO;
import com.training.module8.model.Book;


@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final List<Book> books = new ArrayList<>( 
			List.of(
			new Book(1L,"Java 101","Author of Java 101"),
			new Book(2L,"Java 102","Author of Java 102"),
			new Book(3L,"Java 103","Author of Java 103")
			));
	
	private int bookcount = 4;

	@GetMapping
	public List<BookDTO> getAll() {
		return books.stream()
		.map(b-> new BookDTO(b.getTitle(),b.getAuthor()))
		.toList();
	}

    @GetMapping("/delete/{id}")
    public BookDTO deleteBook(@PathVariable Long id) {
        Book forDeletion = books.stream()
            .filter(b -> b.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("not found"));

        books.removeIf(b -> b.getId().equals(id));

        return new BookDTO(forDeletion.getTitle(),forDeletion.getAuthor());
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Book create(@RequestBody Book book) {
		book.setId(Long.valueOf(bookcount));
		books.add(book);
		bookcount++;
		return book;
	}
	
	@GetMapping("/{id}")
	public BookDTO getBook(@PathVariable Long id) {
		return books.stream()
				.filter(b -> b.getId().equals(id))
				.findFirst()
				.map(b -> (new BookDTO(b.getTitle(),b.getAuthor())))
				.orElse(null);
	}
	
	@GetMapping("/search")
	public List<BookDTO> search(
			@RequestParam(required = false) String title,
			@RequestParam(required = false) String author
			) {
		return books.stream()
				.filter(b -> b.getTitle() != null && b.getTitle().equals(title))
				.filter(b -> author == null || b.getAuthor().equals(author))
				.map(b -> new BookDTO(b.getTitle(), b.getAuthor()))
				.toList();
	}
	
	@ResponseBody
	@GetMapping("/old")
	public List<BookDTO> getAllUsingResponseBody() {
		return books.stream()
				.map(b -> new BookDTO(b.getTitle(), b.getAuthor()))
				.toList();
	}
	
}
