package com.hcl.dto;

import com.hcl.model.Loan;
import jakarta.persistence.*;

import java.util.List;

public class CustomerRequest {
    private String customerName;
    private Long customerContactNumber;
    private List<LoanRequest> loanList;
    public CustomerRequest(){}
    public CustomerRequest(String customerName, Long customerContactNumber, List<LoanRequest> loanList) {
        this.customerName = customerName;
        this.customerContactNumber = customerContactNumber;
        this.loanList = loanList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(Long customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    public List<LoanRequest> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<LoanRequest> loanList) {
        this.loanList = loanList;
    }
}
