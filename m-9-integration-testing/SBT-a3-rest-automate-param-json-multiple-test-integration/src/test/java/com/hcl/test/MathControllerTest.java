package com.hcl.test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.hcl.test.controller.MathController;
import com.hcl.test.service.MathService;

import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MathService mathService;

    @InjectMocks
    private MathController mathController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Providing test cases as an argument stream
    static Stream<Arguments> mathTestData() {
        return Stream.of(
            Arguments.of(3, 1, 4),
            Arguments.of(5, 1, 6),
            Arguments.of(3, 14, 17)
        );
    }

    @ParameterizedTest
    @MethodSource("mathTestData")
    void testGetResult(int a, int b, int expected) throws Exception {
        // Mocking the behavior of the MathService
        when(mathService.addTwoNumber(a, b)).thenReturn(expected);//functional testing

        mockMvc.perform(//rest api testing
                get(String.format("/api/test/v1/result/%d/%d", a, b))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expected)));
    }
    
    
    @ParameterizedTest
    @MethodSource("provideTestParameters")  // Adjust the method source as needed
    void testGetList(String expectedKey, String expectedValue) throws Exception {
        mockMvc.perform(
                get("/api/test/v1/list")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())  // Expect 200 OK
        .andExpect(jsonPath("$." + expectedKey).value(expectedValue));  // Check JSON response
    }

    private static Stream<Arguments> provideTestParameters() {
        return Stream.of(
            Arguments.of("1", "First Item"), 
            Arguments.of("2", "Second Item")
        );
    }
    
}