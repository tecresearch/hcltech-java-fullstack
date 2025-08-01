package com.cetpa.exception;

import java.util.List;

public class ValidationResponse 
{
	private String message;
	private List<String> errorList;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getErrorList() {
		return errorList;
	}
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
	
}
