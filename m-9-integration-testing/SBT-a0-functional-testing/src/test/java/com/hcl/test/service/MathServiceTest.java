package com.hcl.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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



		@ParameterizedTest
		@CsvSource({
				"1,1",
				"2, 8",
				"3, 27"
		})
		public void test_GetCube(int number, int expected) {
			int result=mathService.getCube(number);
		 	assertEquals(expected,result);
		}

	static Stream<Arguments> maxArrayProvider() {
		return Stream.of(
				Arguments.of(new int[]{1, 2, 3}, 3),
				Arguments.of(new int[]{5, 4, 2}, 5),
				Arguments.of(new int[]{-1, -2, -3}, -1),
				Arguments.of(new int[]{0, 0, 0}, 0)
		);
	}
	@ParameterizedTest
	@MethodSource("maxArrayProvider")
	void test_GetMax(int[] input, int expected) {
		int result = mathService.getMax(input);
		assertEquals(expected, result);
	}

	@ParameterizedTest
	@CsvSource({
			"50, 2.60",
			"100, 3.25",
			"200, 5.26",
			"1000, 7.75"
	})
	public void test_TarifRates(int unit,double expected) {

		System.out.println("test case to write");


	}

}
