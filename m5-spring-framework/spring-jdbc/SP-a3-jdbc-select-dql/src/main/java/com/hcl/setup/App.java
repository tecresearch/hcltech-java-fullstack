package com.hcl.setup;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.mapper.EmployeeMapper;
import com.hcl.model.Employee;
import com.hcl.setup.config.SpringConfig;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

		try {
			// Run a simple query to test the connection
			jdbcTemplate.execute("SELECT 1");
			System.out.println("Spring JDBC Configured successfully and DB connection is valid.");
		} catch (DataAccessException e) {
			System.out.println("Failed DB Connection: " + e.getMessage());
		}

		// Select Operation
		
		String select_sql_query = "select * from employees ";
		List<Employee> list = jdbcTemplate.query(select_sql_query, new EmployeeMapper());
		for (Employee emp : list) {
			System.out.println(emp);
		}

		// Select Operation
		int id=101;
		String select_one__sql_query = "select * from employees where id=?";
		List<Employee> list2 = jdbcTemplate.query(select_one__sql_query, new EmployeeMapper(),id);
		for (Employee emp : list2) {
			System.out.println(emp);
		}
		
		// Select Operation
				
				String select_one_Object__sql_query = "select * from employees where id=?";
				Employee emps = jdbcTemplate.queryForObject(select_one_Object__sql_query, new EmployeeMapper(),id);
				System.out.println(emps);

	}

}
