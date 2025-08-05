package com.hcl;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.controller.CustomerController;
import com.hcl.dto.CustomerRequest;
import com.hcl.model.Customer;
import com.hcl.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class CustomerControllerTest {

    @Mock
    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }
    @Test
    public void testAddCustomer() throws Exception {
        CustomerRequest customerRequest = new CustomerRequest(); // Populate your CustomerRequest object here
        when(customerService.addCustomer(any(CustomerRequest.class))).thenReturn(customerRequest);

        mockMvc.perform(
                        get("/api/customer/v1/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("name", "John Doe") // Adjust parameters as needed
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(customerService).addCustomer(any(CustomerRequest.class));
    }

}