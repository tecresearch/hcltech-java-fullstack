package com.hcl.dto.mapper;

import com.hcl.dto.CustomerRequest;
import com.hcl.dto.LoanRequest;
import com.hcl.model.Customer;
import com.hcl.model.Loan;
import org.modelmapper.ModelMapper;

public class EntityMapper {
    public static CustomerRequest toCustomerRequest(Customer customer) {
        ModelMapper modelMapper = new ModelMapper();
        CustomerRequest customerRequest =modelMapper.map(customer, CustomerRequest.class);
        return customerRequest;
    }
    public static Customer toCustomer(CustomerRequest customerRequest) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer =modelMapper.map(customerRequest, Customer.class);
        return customer;
    }

    public static LoanRequest toLoanRequest(Loan loan) {
        ModelMapper modelMapper = new ModelMapper();
        LoanRequest loanRequest =modelMapper.map(loan, LoanRequest.class);
        return loanRequest;
    }
    public static Loan toLoan(LoanRequest loanRequest) {
        ModelMapper modelMapper = new ModelMapper();
        Loan loan =modelMapper.map(loanRequest, Loan.class);
        return loan;
    }

}
