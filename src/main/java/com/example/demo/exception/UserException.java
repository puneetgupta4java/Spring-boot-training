package com.example.demo.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings({ "serial" })
public class UserException extends RuntimeException{
	String message;
	HttpStatus httpStatus;
	
	public UserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public UserException(String message) {
		this.message = message;
	}
	
	
	public UserException(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage()
	{
		return message;
	}

	@Override
	public String toString() {
		return "UserException [message=" + message + "]";
	}
	
}
