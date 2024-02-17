package com.bookmanagement.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bookmanagement.customexception.BookNotFoundException;

@RestControllerAdvice
public class ValidationController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> validationHandle(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();

	    ex.getBindingResult().getFieldErrors().forEach((error) -> {
	        errors.put(error.getField(), error.getDefaultMessage());
	    });
	    
	    ex.getBindingResult().getAllErrors().forEach((er)->{
	    	errors.put(er.getCode(), er.getDefaultMessage());
	    });

	    return ResponseEntity.badRequest().body(errors);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public Map<String, String> bookException(BookNotFoundException ex){
		
		Map<String, String> errors = new HashMap<String, String>();
		
		errors.put("error", ex.getMessage());
		return errors;
	}


}
