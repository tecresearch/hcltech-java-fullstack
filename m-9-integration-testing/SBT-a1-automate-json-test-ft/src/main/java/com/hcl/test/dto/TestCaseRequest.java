package com.hcl.test.dto;
public class TestCaseRequest {
	public int id;
	public int a;
	public int b;
	public int expected;
	public boolean status = false;
	public TestCaseRequest(int id, int a, int b, int expected, boolean status) {
		 
		this.id = id;
		this.a = a;
		this.b = b;
		this.expected = expected;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getExpected() {
		return expected;
	}
	public void setExpected(int expected) {
		this.expected = expected;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public TestCaseRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TestCaseRequest [id=" + id + ", a=" + a + ", b=" + b + ", expected=" + expected + ", status=" + status
				+ "]";
	}
	
	

}