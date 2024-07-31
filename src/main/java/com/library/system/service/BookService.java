package com.library.system.service;

import java.util.List;

import com.library.system.exception.BookRegistrationException;
import com.library.system.exception.BookRetrievalException;
import com.library.system.model.Book;

public interface BookService {

	public Book registerBook(Book book) throws BookRegistrationException;

	public List<Book> getAllBooks() throws BookRetrievalException;

}
