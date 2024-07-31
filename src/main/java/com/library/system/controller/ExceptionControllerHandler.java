package com.library.system.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.library.system.exception.BookRegistrationException;
import com.library.system.exception.BookRetrievalException;
import com.library.system.exception.BorrowerRegistrationException;
import com.library.system.exception.BorrowerRetrivalException;
import com.library.system.exception.BorrowingException;
import com.library.system.exception.RecordNotFoundException;

@ControllerAdvice
public class ExceptionControllerHandler {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionControllerHandler.class);

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
		logger.error("Runtime Exception occurred: {}", e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
	}

	@ExceptionHandler(BookRetrievalException.class)
	public ResponseEntity<String> handleBookRetrievalException(BookRetrievalException e) {
		logger.error("Runtime Exception occurred: {}", e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	@ExceptionHandler(BookRegistrationException.class)
	public ResponseEntity<String> handleBookRegistrationException(BookRegistrationException e) {
		logger.error("Runtime Exception occurred: {}", e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	@ExceptionHandler(BorrowerRegistrationException.class)
	public ResponseEntity<String> handleBorrowRegistrationException(BorrowerRegistrationException e) {
		logger.error("Runtime Exception occurred: {}", e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	@ExceptionHandler(BorrowerRetrivalException.class)
	public ResponseEntity<String> handleBorrowRetrivalException(BorrowerRetrivalException e) {
		logger.error("Runtime Exception occurred: {}", e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	@ExceptionHandler(BorrowingException.class)
	public ResponseEntity<String> handleBorrowingException(BorrowingException e) {
		logger.error("Borrowing Exception: {}", e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGlobalException(Exception e) {
		logger.error("Unhandled exception: {}", e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> handleRecordNotFoundException(RecordNotFoundException e) {
		logger.error("Record Not Found: {}", e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}
