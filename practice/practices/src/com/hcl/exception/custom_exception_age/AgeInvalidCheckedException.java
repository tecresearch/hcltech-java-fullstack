package com.hcl.exception.custom_exception_age;

public class AgeInvalidCheckedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		 
		return "Invalid age ";
	}

}
