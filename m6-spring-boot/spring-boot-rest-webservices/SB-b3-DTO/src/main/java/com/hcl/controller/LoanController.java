package com.hcl.controller;

import com.hcl.dto.CustomerRequest;
import com.hcl.dto.LoanRequest;
import com.hcl.model.Customer;
import com.hcl.model.Loan;
import com.hcl.service.CustomerService;
import com.hcl.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/loan/v1")
public class LoanController {
    @Autowired
    private LoanService loanService;
    @GetMapping("/add")
    public ResponseEntity<Loan> addLoan(LoanRequest loanRequest){
        return ResponseEntity.ok().body(loanService.addLoan(loanRequest));
    }

}
