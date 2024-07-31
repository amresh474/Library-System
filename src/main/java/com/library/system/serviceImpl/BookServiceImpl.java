package com.library.system.serviceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.library.system.exception.BookRegistrationException;
import com.library.system.exception.BookRetrievalException;
import com.library.system.model.Book;
import com.library.system.repository.BookRepository;
import com.library.system.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book registerBook(Book book) throws BookRegistrationException {
		try {

			List<Book> existingBooks = bookRepository.findByIsbn(book.getIsbn());

			for (Book existingBook : existingBooks) {

				if (!existingBook.getTitle().equals(book.getTitle())
						|| !existingBook.getAuthor().equals(book.getAuthor())) {
					throw new BookRegistrationException(
							"ISBN conflict: Existing book with the same ISBN has different title or author.");
				}
			}

			return bookRepository.save(book);
		} catch (DataAccessException e) {
			throw new BookRegistrationException("Failed to register book.", e);
		} catch (Exception e) {
			throw new BookRegistrationException(e.getMessage(), e);
		}

	}

	@Override
	public List<Book> getAllBooks() throws BookRetrievalException {
		try {
			 List<Book> books = bookRepository.findAll();
			 return books != null ? books : Collections.emptyList(); 
		} catch (DataAccessException e) {
			throw new BookRetrievalException("Failed to retrieve books.", e);
		} catch (Exception e) {
			throw new BookRetrievalException(e.getMessage(), e);
		}
	}

}
