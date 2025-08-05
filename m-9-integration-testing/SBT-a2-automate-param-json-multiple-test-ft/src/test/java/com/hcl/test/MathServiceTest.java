package com.hcl.test;

import java.io.File;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.test.dto.TestCaseRequest;
import com.hcl.test.service.MathService;

@SpringBootTest
class MathServiceTest {
  
    @Autowired
    private MathService mathService;
  
    // Method to provide parameters to the test
    static Stream<TestCaseRequest> testCases() throws Exception {
        String testCasePath = "src/test/resources/test.json";
        ObjectMapper mapper = new ObjectMapper();
        List<TestCaseRequest> tests = List.of(mapper.readValue(new File(testCasePath), TestCaseRequest[].class));
        return tests.stream(); // Convert list to stream
    }
  
    @ParameterizedTest
    @MethodSource("testCases")
    public void testAdd_FromJsonFile(TestCaseRequest test) throws Exception {
    	// Generate a unique ID  
        test.id = (int) System.nanoTime(); // or any other ID generation logic

        // Perform the addition
        int result = mathService.addTwoNumber(test.a, test.b);
        
        // Update status based on the result
        test.status = (test.expected == result);

        // Assert that the result matches the expected value
        Assertions.assertEquals(test.expected, result, "The addition result is incorrect for test case id: " + test.id);

        // Send the result to the service
        mathService.sendResult(List.of(test)); // Wrap in a list to send
        mathService.getResult();
    }
}