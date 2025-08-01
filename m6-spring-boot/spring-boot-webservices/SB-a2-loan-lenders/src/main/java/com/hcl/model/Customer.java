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

}
