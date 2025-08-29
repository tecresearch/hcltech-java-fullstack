package com.hackerrank.whc.controller;

import com.hackerrank.whc.repository.CustomerRepository;

public class CustomerController {

    final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
