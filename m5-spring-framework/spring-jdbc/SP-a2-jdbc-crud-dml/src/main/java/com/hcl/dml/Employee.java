package com.hcl.dml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.setup.config.SpringConfig;

/**
 * Hello world!
 *
 */
public class Employee 
{
    public static void main( String[] args )
    {
//    	int id=101;
//    	String name="Brijesh";
//    	String email="bnlv121b2@gmail.com";
//    	int salary=20000;
    	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    	JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        
    	//insert operation 
    	
//    	String insert_sql_query="insert into employees values(?,?,?,?)";
//    	int rowAffected=jdbcTemplate.update(insert_sql_query,id,name,email,salary);
//    	if(rowAffected>0) {
//    		System.out.println("Data Inserted");
//    	}
//    	
    	
//update operation 
//    	
//    	int id=11;
//    	String name="Brijesh";
//    	String email="bnlv121b2@gmail.com";
//    	int salary=22300;
//    	
//    	String update_sql_query="update  employees set salary=? where id=?";
//    	int rowAffected=jdbcTemplate.update(update_sql_query,salary,id);
//    	if(rowAffected>0) {
//    		System.out.println("Data updated");
//    	}
//    	
    	
//delete operation 
    	
    	int id=11;
    	String name="Brijesh";
    	String email="bnlv121b2@gmail.com";
    	int salary=22300;
    	
    	String delete_sql_query="delete from employees where id=?";
    	int rowAffected=jdbcTemplate.update(delete_sql_query,id);
    	if(rowAffected>0) {
    		System.out.println("Data deleted");
    	}
    	
        
    	
    	
    }
}
