package com.training.module8.dto;

import com.training.module8.model.Book;

public class BookDTO {
	
	private Long id;
	private String title;
	private String author;
	
	public BookDTO() {}

	public BookDTO(Long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public BookDTO (Book book) {
		this.setId(book.getId());
		this.setTitle(book.getTitle());
		this.setAuthor(book.getAuthor());
	}
	
	public Book toEntity() {
		Book book = new Book();
		book.setId(this.getId());
		book.setTitle(this.getTitle());
		book.setAuthor(this.getAuthor());
		return book;
	}

}
