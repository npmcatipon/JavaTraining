package com.bpi.training.module10.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalHandlerException {

	@ExceptionHandler(UsernameAlreadyExistException.class)
	public ResponseEntity<ApiResponse> handleUsernameAlreadyExist(
		RuntimeException ex,
		HttpServletRequest req) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(
						ApiResponse.of(
							HttpStatus.CONFLICT.value(), 
							"Error on creating new user.", 
							ex.getMessage(), 
						req.getRequestURI())
					);
	}
	
}
