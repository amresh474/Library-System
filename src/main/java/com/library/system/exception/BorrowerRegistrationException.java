package com.library.system.exception;



public class BorrowerRegistrationException extends RuntimeException {
	public BorrowerRegistrationException(String message) {
		super(message);
	}

	public BorrowerRegistrationException(String message, Throwable cause) {
		super(message, cause);
	}
}
