package com.bpi.group.project;

public class Library {
	// can contain up to 5 books	
	private int id;
	private Book book;
	private User user;
	private final int bookLimit = 5;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
