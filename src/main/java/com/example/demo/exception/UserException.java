package com.example.demo.exception;


@SuppressWarnings({ "serial" })
public class UserException extends RuntimeException{
	String message;

	
	public UserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserException(String message) {
		this.message = message;
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
