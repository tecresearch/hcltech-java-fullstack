package com.cg.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ResponseBody
	@ExceptionHandler({EmployeeNotFoundException.class})
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMapper handleException(Exception e, HttpServletRequest request) {
		String uri=request.getRequestURI();
		return new ErrorMapper(uri,e.getMessage(),LocalDateTime.now());
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @ExceptionHandler({MethodArgumentNotValidException.class})
	 * 
	 * @ResponseStatus(value = HttpStatus.BAD_REQUEST) public ErrorMapper
	 * handleException1(MethodArgumentNotValidException e, HttpServletRequest
	 * request) { String uri=request.getRequestURI(); List<ObjectError> li=
	 * e.getBindingResult().getAllErrors(); String errorMsg=""; for(ObjectError
	 * err:li) { errorMsg+=err.getDefaultMessage(); } return new
	 * ErrorMapper(uri,errorMsg,LocalDateTime.now()); }
	 */
	
	@ResponseBody
	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Map<String, ErrorMapper> handleException1(MethodArgumentNotValidException e, HttpServletRequest request) {
		String uri=request.getRequestURI();
		List<ObjectError> li= e.getBindingResult().getAllErrors();
		Map<String, ErrorMapper> m=new HashMap<>();
		for(ObjectError err:li) {
			String fieldName=((FieldError)err).getField();
			String msg=err.getDefaultMessage();
			m.put(fieldName,new ErrorMapper(request.getRequestURI(), msg, LocalDateTime.now()));
		}
		return m;
	}
}
