package com.school.exception;



import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
     @ExceptionHandler(ResourceNotFounExceptionHandling.class)
	public ResponseEntity<String> validationexceptionHandiling(ResourceNotFounExceptionHandling ex){
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()) ;
	}
}
