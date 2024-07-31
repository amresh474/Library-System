package com.library.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.system.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByIsbn(String isbn);

}
