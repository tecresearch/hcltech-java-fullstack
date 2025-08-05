package com.hcl.controller;

import com.hcl.dto.CustomerRequest;

import com.hcl.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer/v1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/add")
    public ResponseEntity<CustomerRequest> addCustomer(CustomerRequest customerRequest){
        return ResponseEntity.ok().body(customerService.addCustomer(customerRequest));
    }

}
