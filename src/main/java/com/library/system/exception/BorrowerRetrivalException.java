package com.library.system.exception;

public class BorrowerRetrivalException extends RuntimeException {
	public BorrowerRetrivalException(String message) {
		super(message);
	}

	public BorrowerRetrivalException(String message, Throwable cause) {
		super(message, cause);
	}
}
