package com.hcl.employee;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hcl.employee.controller.EmployeeController;
import com.hcl.employee.repository.impl.EmployeeRepositoryImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        	 new EmployeeController(); 
    }
}
