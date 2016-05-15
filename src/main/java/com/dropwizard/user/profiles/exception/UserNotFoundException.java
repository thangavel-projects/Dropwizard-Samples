package com.dropwizard.user.profiles.exception;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = -6639790360595117807L;

	public UserNotFoundException(String message, Throwable cause){
		super(message, cause);
	}

	public UserNotFoundException() {
		super();
	}
}
