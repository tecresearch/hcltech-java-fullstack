package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.bean.Employee;
import com.cg.dao.IEmployeeRepo;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.service.EmployeeService;


@SpringBootTest
class SpringDataJpaExampleApplicationTests {
	
	@Mock
	private IEmployeeRepo repo;
	@InjectMocks
	private EmployeeService service;
	
	/*
	 * @Test void checkEmployeeWithValidID() throws EmployeeNotFoundException {
	 * Employee emp=new Employee(101, "Aman", LocalDate.now(), 56000,
	 * "aman@gmail.com"); Optional<Employee> op=Optional.of(emp);
	 * 
	 * when(repo.findById(101)).thenReturn(op);
	 * 
	 * assertNotNull(service.getEmployeeByID(101)); assertEquals("Aman",
	 * service.getEmployeeByID(101).getName()); }
	 */
	
	/*
	 * @Test void checkEmployeeWithInvalidID() throws EmployeeNotFoundException {
	 * assertThrows(EmployeeNotFoundException.class,
	 * ()->service.getEmployeeByID(15));
	 * 
	 * }
	 */
}
