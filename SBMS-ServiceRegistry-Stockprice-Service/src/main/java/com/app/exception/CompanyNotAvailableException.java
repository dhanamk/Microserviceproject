package com.app.exception;

public class CompanyNotAvailableException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompanyNotAvailableException(String message) {
	super(message);
	}
}
