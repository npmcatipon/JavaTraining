package com.training.module8.dto;

import com.training.module8.model.Book;

public class BookDTO {
	
	private String title;
	private String author;
	
	public BookDTO() {}

	public BookDTO(String title, String author) {
		this.title = title;
		this.author = author;
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
		this.setTitle(book.getTitle());
		this.setAuthor(book.getAuthor());
	}

	public Book toEntity() {
		Book book = new Book();
		book.setTitle(this.getTitle());
		book.setAuthor(this.getAuthor());
		return book;
	}

}
