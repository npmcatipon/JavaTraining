package com.training.module8.model;

public class Book {
	
	private String title;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book(Long id,String string) {
		this.id = id;
		this.title = string;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
