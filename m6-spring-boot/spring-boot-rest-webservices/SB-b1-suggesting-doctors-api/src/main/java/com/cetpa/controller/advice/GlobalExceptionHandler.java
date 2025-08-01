package com.cetpa.controller.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cetpa.exception.DoctorNotFoundException;
import com.cetpa.exception.PatientNotFoundException;
import com.cetpa.exception.ValidationResponse;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		BindingResult bindingResult=ex.getBindingResult();
		List<ObjectError> objectErrors=bindingResult.getAllErrors();
		//List<String> list=objectErrors.stream().map(error->error.getDefaultMessage()).toList();
		List<String> list=new ArrayList<>();
		for(ObjectError error:objectErrors)
		{
			list.add(error.getDefaultMessage());
		}
		ValidationResponse validationResponse=new ValidationResponse();
		validationResponse.setMessage("Validation Failed...");
		validationResponse.setErrorList(list);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationResponse);
	}
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<String> handleDoctorNotDoundException(DoctorNotFoundException ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<String> handlePatientNotFoundException(PatientNotFoundException ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleOtherExceptions(RuntimeException ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
