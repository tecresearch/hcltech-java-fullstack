package com.hackerrank.whc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.whc.model.Customer;
import com.hackerrank.whc.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerRepository customerRepository;

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    public void setup() {
        customer1 = new Customer(1, 180, 75, null);
        customer2 = new Customer(2, 160, 60, null);
    }

    @Test
    public void testAddRecord() throws Exception {
        when(customerRepository.save(any(Customer.class))).thenReturn(customer1);

        mockMvc.perform(post("/api/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer1)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetRecords() throws Exception {
        when(customerRepository.findAll(any(Sort.class))).thenReturn(Arrays.asList(customer1, customer2));

        mockMvc.perform(get("/api/customer")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetRecordsById() throws Exception {
        when(customerRepository.findById(customer1.getId())).thenReturn(Optional.of(customer1));

        mockMvc.perform(get("/api/customer/{id}", customer1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
