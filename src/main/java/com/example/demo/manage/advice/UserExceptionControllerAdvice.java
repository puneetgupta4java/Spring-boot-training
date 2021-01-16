package com.example.demo.manage.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.UserException;

@ControllerAdvice
public class UserExceptionControllerAdvice {
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<String> handleUserException(UserException userException)
	{	
		   HttpHeaders responseHeaders = new HttpHeaders();
		   return new ResponseEntity<String>(userException.toString(), responseHeaders, HttpStatus.BAD_REQUEST); 
	}
}
