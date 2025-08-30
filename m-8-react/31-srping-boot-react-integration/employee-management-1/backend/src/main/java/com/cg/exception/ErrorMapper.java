package com.cg.exception;

import java.time.LocalDateTime;

public class ErrorMapper {
	private String uri;
	private String message;
	private LocalDateTime curDate;
		
	public ErrorMapper() {
		// TODO Auto-generated constructor stub
	}
	public ErrorMapper(String uri, String message, LocalDateTime curDate) {
		super();
		this.uri = uri;
		this.message = message;
		this.curDate = curDate;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getCurDate() {
		return curDate;
	}
	public void setCurDate(LocalDateTime curDate) {
		this.curDate = curDate;
	}
	
	
}
