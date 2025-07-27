package com.hcl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "a8_employees1")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;
    private String firstname;
    private String lastname;
    private String phone;
    private String department;
    private String email;
    private double salary; // Changed to double

    public Employee() {
        super();
    }

    public Employee(String firstname, String lastname, String phone, String department, String email, double salary) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.department = department;
        this.email = email;
        this.salary = salary;
    }

    // Getters and Setters
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [eid=" + eid + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone
                + ", department=" + department + ", email=" + email + ", salary=" + salary + "]";
    }
}