package com.hcl.setup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.setup.config.SpringConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    	JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

    	try {
    	    // Run a simple query to test the connection
    	    jdbcTemplate.execute("SELECT 1");
    	    System.out.println("Spring JDBC Configured successfully and DB connection is valid.");
    	} catch (DataAccessException e) {
    	    System.out.println("Failed DB Connection: " + e.getMessage());
    	}

         
    }
}
