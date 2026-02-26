package com.training.module8.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "book" )
public class Book {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotNull ( message = "Title cannot be null." )
	@NotBlank ( message = "Title cannot be blank." ) 
	@NotEmpty( message = "Title cannot be empty." )
	@Column ( name = "title" )
	private String title;
	
	@NotNull ( message = "Author cannot be null." )
	@NotBlank ( message = "Author cannot be blank." ) 
	@NotEmpty( message = "Author cannot be empty." )
	@Column ( name = "author" )
	private String author;
	
	public Book(Long id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}
	public Book() {}
	
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
	
}
