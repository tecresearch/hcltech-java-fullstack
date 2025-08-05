package com.hcl.service;

import com.hcl.dto.CustomerRequest;
import com.hcl.dto.LoanRequest;
import com.hcl.dto.mapper.EntityMapper;
import com.hcl.model.Customer;
import com.hcl.model.Loan;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    public Loan addLoan(LoanRequest loanRequest) {
            return EntityMapper.toLoan(loanRequest);
    }
}
