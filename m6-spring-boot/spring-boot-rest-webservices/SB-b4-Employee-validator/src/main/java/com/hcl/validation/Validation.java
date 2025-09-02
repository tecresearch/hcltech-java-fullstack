package com.hcl.validation;

public class Validation {
	
	private String field;
	private String message;
	
	
	public Validation(String field, String message) {
		  
		this.field=field;
		this.message=message;
	}
	
	
	public String getMessge() {
		     return message;
	}
	
	public String getField() {
		    return field;
	}

}
