package com.bpi.training.module10.exception;

import com.bpi.training.module10.Module10Application;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalHandlerException {
private final Module10Application module10Application;

    GlobalHandlerException(Module10Application module10Application) {
        this.module10Application = module10Application;
    }

@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse> handleValidation(
			MethodArgumentNotValidException ex,
			HttpServletRequest req) {
		String message = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.findFirst()
				.map(err -> err.getField() + ": " + err.getDefaultMessage())
				.orElse("Invalid Request");

		return ResponseEntity.badRequest().body(
				ApiResponse.of(400,
						"Bad Request",
						message,
						req.getRequestURI()));
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiResponse> handleConstraintValidation(
			ConstraintViolationException ex,
			HttpServletRequest req) {
		return ResponseEntity.badRequest().body(
				ApiResponse.of(400,
						"Bad Request",
						ex.getMessage(),
						req.getRequestURI()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> handleException(
			Exception ex,
			HttpServletRequest req) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
				ApiResponse.of(500,
						"Internal Server Error",
						"An unexpected error occur.",
						req.getRequestURI()));
	}

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
