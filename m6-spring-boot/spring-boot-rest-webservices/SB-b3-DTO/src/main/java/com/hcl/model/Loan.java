package com.hcl.model;
/*
In a bidirectional @OneToMany relationship in JPA (Hibernate), the owning side is the entity that contains the foreign key and manages the relationship in the database. The non-owning side is mapped with mappedBy and does not control the relationship.

Example:


Loan (non-owning side)-child and Customer (owning side, has the foreign key).
Loan.java (non-owning side):
 */

import jakarta.persistence.*;

public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String loanName;
    @ManyToOne
    @JoinColumn(name="customer_id")//Foreign Key
    private Customer customer;//add customer_id as fk references to pk
    public Loan(){}
    public Loan(long id, String loanName, Customer customer) {
        this.id = id;
        this.loanName = loanName;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
