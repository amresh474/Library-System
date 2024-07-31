package com.library.system.controller;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{
	
	 private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ValidationHandler.class);
	
	   @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	                                                                  HttpHeaders headers,
	                                                                  HttpStatusCode status,
	                                                                  WebRequest request) {

	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getAllErrors().forEach((error) -> {
	            String fieldName = ((FieldError) error).getField();
	            String message = error.getDefaultMessage();
	            errors.put(fieldName, message);
	        });
	        logger.error("Validation errors: {}", errors); // Log the errors
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
