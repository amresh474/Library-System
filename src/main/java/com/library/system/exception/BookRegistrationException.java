package com.library.system.exception;

public class BookRegistrationException extends Exception {
	public BookRegistrationException(String message) {
		super(message);
	}

	public BookRegistrationException(String message, Throwable cause) {
		super(message, cause);
	}
}
