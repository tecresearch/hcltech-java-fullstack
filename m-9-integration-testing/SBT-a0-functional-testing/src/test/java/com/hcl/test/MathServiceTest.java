package com.hcl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.test.service.MathService;

@SpringBootTest
class MathServiceTest {

	@Autowired
	private MathService mathService;

	class TestCaseRequest {

		int a;
		int b;
		int expected;

		public TestCaseRequest(int a, int b, int expected) {

			this.a = a;
			this.b = b;
			this.expected = expected;
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

	}

	public void helperMethod(TestCaseRequest testCaseRequest) {
		int result = mathService.addTwoNumber(testCaseRequest.getA(), testCaseRequest.getB());
		assertEquals(testCaseRequest.getExpected(), result);
	}

	@Test
	public void testAdd_Common() {

		List<TestCaseRequest> caseRequests = new ArrayList<>();

		TestCaseRequest testCaseRequest1 = new TestCaseRequest(1, 2, 3);
		TestCaseRequest testCaseRequest2 = new TestCaseRequest(12, 2, 14);
		TestCaseRequest testCaseRequest3 = new TestCaseRequest(13, 2, 15);
		caseRequests.add(testCaseRequest1);
		caseRequests.add(testCaseRequest2);
		caseRequests.add(testCaseRequest3);

		for (TestCaseRequest test : caseRequests) {

			helperMethod(test);

		}

	}

	@Test
	public void testAdd_PositiveNumber1() {
		int result = mathService.addTwoNumber(15, 5);
		assertEquals(20, result);
	}

	@Test
	public void testAdd_PositiveNumber2() {
		int result = mathService.addTwoNumber(123, 0);
		assertEquals(123, result);
	}

	@Test
	public void testAdd_NegativeNumber1() {
		int result = mathService.addTwoNumber(-3, 10);
		assertEquals(7, result);
	}

	@Test
	public void testAdd_NegativeNumber2() {
		int result = mathService.addTwoNumber(-3, -10);
		assertEquals(-13, result);
	}

	@Test
	public void test_Add_IntegerMaxValue() {
		int a = Integer.MAX_VALUE;
		int b = 1;

		int result = mathService.addTwoNumber(a, b);
		assertEquals(Integer.MIN_VALUE, result);
	}

	@Test
	public void test_Add_IntegerMinValue() {
		int a = Integer.MIN_VALUE;
		int b = -1;
		int result = mathService.addTwoNumber(a, b);
		assertEquals(Integer.MAX_VALUE, result);

	}

	@Test
	public void test_Add_IntegerZero() {
		int a = 0;
		int b = 0;

		int result = mathService.addTwoNumber(a, b);
		assertEquals(0, result);
	}
	
	@Test
	public void test_Add_IntegerRange() {
		 int a = Integer.MAX_VALUE;
		int b = 1;

		int result = mathService.addTwoNumber(a, b);
		assertEquals(Integer.MIN_VALUE, result);
	}
	

}
