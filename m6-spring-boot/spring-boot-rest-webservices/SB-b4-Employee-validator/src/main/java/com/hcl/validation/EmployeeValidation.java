package com.hcl.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.hcl.model.Employee;

@Component
public class EmployeeValidation {
	
	    private static final Pattern MOBILE_PATTERN=Pattern.compile("\\d{10}");
	    
	    private static final Pattern DOB_PATTERN=Pattern.compile("\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])");
	    
	    private static final Pattern EMAIL_PATTERN=Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
	    
	    
	    public List<Validation>validate(Employee emp){
	    	
	    	   List<Validation> errors=new ArrayList<>();
	    	   
	    	   
	    	   //for mobile number
	    	   if(!StringUtils.hasText(emp.getMobileNumber())) {
	    		   
	    		      errors.add(new Validation("mobileNumber", "The mobile number is mandatory field"));
	    	   }else if(!MOBILE_PATTERN.matcher(emp.getMobileNumber()).matches()) {
	    		    errors.add(new Validation("mobileNumber", "The mobile number is mandatory field"));
	    	   }
	    	   
	    	   //for fullNAME
	    	   
	    	    if(!StringUtils.hasText(emp.getFullName())) {
	    		       errors.add(new Validation("fullName","The full name is mandatory"));
	    	   }
	    	    
	    	    
	    	    
	    	    //FOR EMAIL
	    	    if(!StringUtils.hasText(emp.getEmailId())) {
	    	    	  errors.add(new Validation("Email","The email is mandatory"));
	    	    }else if(!EMAIL_PATTERN.matcher(emp.getEmailId()).matches()) {
	    	    	   errors.add(new Validation("email","The emailId should be  in a valid email format"));
	    	    }
	    	    
	    	    
	    	    //FOR DOB
	    	    
	    	    if(!StringUtils.hasText(emp.getDateOfBirth())) {
	    	    	
	    	    	errors.add(new Validation("date of birth","The date of birth is mandatory"));
	    	    }else if(!DOB_PATTERN.matcher(emp.getDateOfBirth()).matches()) {
	    	    	   errors.add(new Validation("date of birth", "The dateOfBirth should be in YYYY-MM-DD format"));
	    	    }
	    	    
	    	    
	    	    return errors;
	    	    
	    	    
  
	    }
	    
	

}
