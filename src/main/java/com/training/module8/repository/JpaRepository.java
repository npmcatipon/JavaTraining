package com.training.module8.repository;

import java.util.ArrayList;
import java.util.List;

import com.training.module8.dto.BookDTO;
import com.training.module8.model.Book;

public interface JpaRepository <T, ID> {
	
	List <Book> books = new ArrayList<>();
	
	public List<BookDTO> getAll();
	
	public void create();

}
