package com.hcl.exception.custom_exception_age;

public class PercentageException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8489687968820884177L;

	@Override
	public String getMessage() {
		return "Percentage should be greater than 75 or equal";
	}
}
