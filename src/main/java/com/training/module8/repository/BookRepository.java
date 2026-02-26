package com.training.module8.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.training.module8.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
