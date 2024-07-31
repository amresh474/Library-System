package com.library.system.exception;

public class BorrowingException extends RuntimeException {
	public BorrowingException(String message) {
		super(message);
	}

	public BorrowingException(String message, Throwable cause) {
		super(message, cause);
	}

}
