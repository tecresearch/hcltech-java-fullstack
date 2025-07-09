package com.hcl.exception.custom_exception_age;

public class AgeInvalidExceptionRunTime extends RuntimeException{

	@Override
	public String getMessage() {
		 
		return "Invalid age ";
	}

}
