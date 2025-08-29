package com.hackerrank.validator.validation;

import com.hackerrank.validator.model.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object employeeObject, Errors errors) {
        Employee employee = (Employee) employeeObject;
        if(employee.getFullName() == null || employee.getFullName().trim().isEmpty()){
            errors.rejectValue("fullName", "fullName.empty", "The fullName is a mandatory field");
        }

        if(employee.getMobileNumber() == null || String.valueOf(employee.getMobileNumber()).length()!=10 ){
            errors.rejectValue("mobileNumber", "mobileNumber.isinvalid", "The mobileNumber is a mandatory field");
        }

        if(employee.getEmailId() == null || employee.getEmailId().trim().isEmpty()){
            errors.rejectValue("emailId", "emailId.isEmpty","The emailId is a mandatory field");
        }else if(!employee.getEmailId().contains("@")){
            errors.rejectValue("emailId", "emailId.isEmpty","The emailId should be in a valid email format");
        }

        if(employee.getDateOfBirth() == null || employee.getDateOfBirth().trim().isEmpty()){
            errors.rejectValue("dateOfBirth", "dateOfBirth.empty", "The dateOfBirth is a mandatory field");
        }else{
            try{
                LocalDate.parse(employee.getDateOfBirth(),DATE_FORMATTER);
            }catch(DateTimeParseException e){
                errors.rejectValue("dateOfBirth", "dateOfBirth.invalid", "The dateOfBirth should be in YYYY-MM-DD format");
            }
        }

    }
}
