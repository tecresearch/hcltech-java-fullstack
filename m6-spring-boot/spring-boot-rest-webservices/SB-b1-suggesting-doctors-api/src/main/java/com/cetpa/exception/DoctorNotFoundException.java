package com.cetpa.exception;

public class DoctorNotFoundException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	public DoctorNotFoundException() 
	{
		super("Doctor does not exist");
	}
	public DoctorNotFoundException(String msg) 
	{
		super(msg);
	}
	
}
