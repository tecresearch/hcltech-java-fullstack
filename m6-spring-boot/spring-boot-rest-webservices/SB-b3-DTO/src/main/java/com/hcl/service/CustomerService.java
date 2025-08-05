package com.hcl.service;

import com.hcl.dto.CustomerRequest;
import com.hcl.dto.LoanRequest;
import com.hcl.dto.mapper.EntityMapper;
import com.hcl.model.Customer;
import com.hcl.model.Loan;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerService {
    public  CustomerRequest addCustomer(CustomerRequest customerRequest) {

        CustomerRequest data=new CustomerRequest();
        data.setCustomerName("Brijesh");
        data.setCustomerContactNumber(1235423L);
        LoanRequest loanRequest=new LoanRequest();
        loanRequest.setCustomer(EntityMapper.toCustomer(data));
        loanRequest.setLoanName("edu");
        LoanRequest loanRequest1=new LoanRequest();
        loanRequest.setCustomer(EntityMapper.toCustomer(data));
        loanRequest.setLoanName("edu");
        LoanRequest loanRequest2=new LoanRequest();
        loanRequest.setCustomer(EntityMapper.toCustomer(data));
        loanRequest.setLoanName("edu");
        List<LoanRequest> loans=new ArrayList<>();
        loans.add(loanRequest);
       loans.add(loanRequest1);
       loans.add(loanRequest2);
        data.setLoanList(loans);
        return data;

    }
}
