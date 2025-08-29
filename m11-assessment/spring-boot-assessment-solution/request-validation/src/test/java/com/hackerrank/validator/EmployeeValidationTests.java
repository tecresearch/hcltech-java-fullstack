package com.hackerrank.validator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.validator.model.Employee;
import com.hackerrank.validator.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class EmployeeValidationTests {
    @Autowired
    EmployeeRepository employeeRepository;
    ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNullEmployee() throws Exception {
        Employee employee = new Employee(null, null, null, null);

        mockMvc.perform(post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employee)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].message").value("The fullName is a mandatory field"))
                .andExpect(jsonPath("$[1].message").value("The mobileNumber is a mandatory field"))
                .andExpect(jsonPath("$[2].message").value("The emailId is a mandatory field"))
                .andExpect(jsonPath("$[3].message").value("The dateOfBirth is a mandatory field"));
    }

    @Test
    public void testEmptyEmployee() throws Exception {
        Employee employee = new Employee("", 0l, "", "");

        mockMvc.perform(post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employee)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].message").value("The fullName is a mandatory field"))
                .andExpect(jsonPath("$[1].message").value("The mobileNumber is a mandatory field"))
                .andExpect(jsonPath("$[2].message").value("The emailId is a mandatory field"))
                .andExpect(jsonPath("$[3].message").value("The dateOfBirth is a mandatory field"));
    }

    @Test
    public void testInvalidMobileNumber() throws Exception {
        Employee employee = new Employee("Foo Bar", 123456789l, "test@gmail.com", "1999-01-01");

        mockMvc.perform(post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employee)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].message").value("The mobileNumber is a mandatory field"));

        employee.setMobileNumber(12345678901l);
        mockMvc.perform(post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employee)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].message").value("The mobileNumber is a mandatory field"));
    }


    @Test
    public void testInvalidEmailId() throws Exception {
        Employee employee = new Employee("Foo Bar", 1234567890l, "test-at-gmail.com", "1999-01-01");

        mockMvc.perform(post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employee)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].message").value("The emailId should be in a valid email format"));
    }

    @Test
    public void testInvalidDob() throws Exception {
        Employee employee = new Employee("Foo Bar", 1234567890l, "test@gmail.com", "1999/01/01");

        mockMvc.perform(post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employee)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].message").value("The dateOfBirth should be in YYYY-MM-DD format"));
    }
}
