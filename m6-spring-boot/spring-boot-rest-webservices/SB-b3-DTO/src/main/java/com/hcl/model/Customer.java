package com.hcl.model;

import jakarta.persistence.*;

import java.util.List;

//Customer should be owning side because

public class Customer {
    @Id
    @GeneratedValue(generator = "my-sequence")
    @SequenceGenerator(name = "my-sequence",initialValue = 523390,allocationSize = 1)
    private Long cutomerId;
    private String customerName;
    private Long customerContactNumber;
    /*
    ref->customer should be reference variable in loan which create fk in loan
     */
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Loan> loanList;
    public Customer(){}
    public Customer(Long cutomerId) {
        this.cutomerId = cutomerId;
    }

    public Long getCutomerId() {
        return cutomerId;
    }

    public void setCutomerId(Long cutomerId) {
        this.cutomerId = cutomerId;
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

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }
}
