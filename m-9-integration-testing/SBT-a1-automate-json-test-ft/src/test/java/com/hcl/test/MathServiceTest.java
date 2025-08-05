package com.hcl.test;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.test.dto.TestCaseRequest;
import com.hcl.test.service.MathService;


@SpringBootTest

class MathServiceTest {
	
	
	@Autowired
	private MathService mathService;
	
	

	@Test
	public void testAdd_FromJsonFile() throws Exception {
		String testCasePath = "src/test/resources/test.json";

		ObjectMapper mapper = new ObjectMapper();

		List<TestCaseRequest> tests = List.of(mapper.readValue(new File(testCasePath), TestCaseRequest[].class));
		int testCount = 1;
		for (TestCaseRequest test : tests) {
			test.id = testCount++;
			int result = mathService.addTwoNumber(test.a, test.b);

			if (test.expected == result) {
				test.status = true;
			}

		}
		
		// send to service 
		
		mathService.sendResult(tests);

		
	

	}

}
