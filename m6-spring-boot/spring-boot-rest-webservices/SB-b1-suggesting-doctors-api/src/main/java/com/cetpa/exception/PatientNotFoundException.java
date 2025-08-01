package com.cetpa.exception;

public class PatientNotFoundException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	public PatientNotFoundException() 
	{
		super("Patient does not exist");
	}
	public PatientNotFoundException(String msg) 
	{
		super(msg);
	}
	
}
