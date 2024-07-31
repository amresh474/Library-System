package com.library.system.exception;

public class BookRetrievalException extends RuntimeException {
	public BookRetrievalException(String message) {
		super(message);
	}

	public BookRetrievalException(String message, Throwable cause) {
		super(message, cause);
	}
}