package com.hcl.exception.custom_exception_age;

public class AdmissionFullException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Admission full";
	}

}
