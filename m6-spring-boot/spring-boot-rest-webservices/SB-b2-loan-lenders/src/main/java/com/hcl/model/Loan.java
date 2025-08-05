package com.hcl.model;
/*
In a bidirectional @OneToMany relationship in JPA (Hibernate), the owning side is the entity that contains the foreign key and manages the relationship in the database. The non-owning side is mapped with mappedBy and does not control the relationship.

Example:


Loan (non-owning side)-child and Customer (owning side, has the foreign key).
Loan.java (non-owning side):
 */

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Loan {
    @ManyToOne
    @JoinColumn(name="customer_id")//Foreign Key
    private Customer customer;//add customer_id as fk references to pk
}
