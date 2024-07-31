package com.library.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.system.exception.BookRegistrationException;
import com.library.system.exception.BookRetrievalException;
import com.library.system.model.Book;
import com.library.system.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping
	public ResponseEntity<?> registerBook(@Valid @RequestBody Book book) throws BookRegistrationException {
		Book registerBook = null;

		registerBook = bookService.registerBook(book);

		if (registerBook == null) {
			throw new BookRegistrationException("Book registration failed");
		}
		return ResponseEntity.ok(registerBook);
	}

	@GetMapping
	public ResponseEntity<?> getAllBooks() {
		List<Book> books = null;

		books = bookService.getAllBooks();
		if (books == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve books.");
		}
		if (books.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No books found.");
		}

		return ResponseEntity.ok(books);
	}

}
