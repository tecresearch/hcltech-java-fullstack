package com.hcl.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.test.dto.TestCaseRequest;

@Service
public class MathService {

	public int addTwoNumber(int a, int b) {

		if (a == Integer.MAX_VALUE && b == 1) {
			return Integer.MIN_VALUE;
		}
		if (a == Integer.MIN_VALUE && b == -1) {
			return Integer.MAX_VALUE;
		}

		return a + b;

	}

	public void successResponse(String msg) {

		System.out.println(msg);

	}

	public void failedResponse(String msg) {
		// TODO Auto-generated method stub
		System.err.println(msg);

	}

	List<TestCaseRequest> res = new ArrayList<>();

	public List<TestCaseRequest> sendResult(List<TestCaseRequest> tests) {
		res.addAll(tests);
		return tests;

	}

	public List<TestCaseRequest> getResult() {
		return res;
	}

}
