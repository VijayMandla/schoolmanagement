package com.school.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandeling {

	public Map<String,String> validationexceptionHandiling(MethodArgumentNotValidException ex){
		
		Map<String , String> errors=new HashMap<>();
		
		ex.getBindingResult()
		.getFieldErrors()
		.forEach(e->
		      errors.put(e.getField(), e.getDefaultMessage())
				);
		return errors;
	}
}
