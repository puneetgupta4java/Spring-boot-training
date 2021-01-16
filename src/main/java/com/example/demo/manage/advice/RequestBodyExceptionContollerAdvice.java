package com.example.demo.manage.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RequestBodyExceptionContollerAdvice {
	
//Used to handle Invalid JSON format Data
	
	@ExceptionHandler({org.springframework.http.converter.HttpMessageNotReadableException.class})
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ResponseBody
	public String resolveException() {
		
		String str1= "\n[\n\t{\n\t\"id\": 123456\",\n\t\"name\": \"Ashi\"\n\t},\n\t {\n\t\"id\": 7890123\",\n\t\"name\": \"Bindal\"\n\t},\n\t.\n\t.\n]";

				//Read more: https://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html#ixzz6jFdvCHU0
		
	    return "Input JSON Format.Acceptable Format: " + str1;
	
	}

}
