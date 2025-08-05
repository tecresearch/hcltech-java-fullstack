package com.hcl.dto;

import com.hcl.model.Customer;
import jakarta.persistence.*;

public class LoanRequest {
    String loanName;
    private Customer customer;//add customer_id as fk references to pk
    public LoanRequest(){}
    public LoanRequest(String loanName, Customer customer) {
        this.loanName = loanName;
        this.customer = customer;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
