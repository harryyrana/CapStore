package com.capgemini.capstore.exceptions;

@SuppressWarnings("serial")
public class WrongUserInputException extends RuntimeException{

	public WrongUserInputException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WrongUserInputException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public WrongUserInputException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public WrongUserInputException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public WrongUserInputException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
