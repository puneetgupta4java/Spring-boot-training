package com.example.demo.manage.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.commons.Constants;

import org.json.JSONArray;


@ControllerAdvice
public class RequestBodyExceptionContollerAdvice {
	
//Used to handle Invalid JSON format Data
	
	@SuppressWarnings("all")
	@ExceptionHandler({org.springframework.http.converter.HttpMessageNotReadableException.class})
	public ResponseEntity<String> resolveException() {
		
		JSONArray array=null;
		try {
			array = new JSONArray(Constants.JSON_ARR_STR);
		
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return new ResponseEntity<>("Wrong Input JSON Format.Acceptable Format Example: " + array ,HttpStatus.BAD_REQUEST);
	    
	
	}

}
