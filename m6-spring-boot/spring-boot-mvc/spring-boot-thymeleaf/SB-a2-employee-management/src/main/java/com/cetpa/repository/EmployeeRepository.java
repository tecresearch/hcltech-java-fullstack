package com.cetpa.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.cetpa.entity.Employee;

@Repository
public class EmployeeRepository 
{
	private Session session;
	private Transaction transaction;
	
	public EmployeeRepository(SessionFactory factory)
	{
		session=factory.openSession();
		transaction=session.getTransaction();
	}
	public void addEmployee(Employee employee)
	{
		transaction.begin();
		session.persist(employee);
		transaction.commit();
	}
	public List<Employee> getEmployeeList()
	{
		Query<Employee> query=session.createQuery("from Employee",Employee.class);
		List<Employee> employeeList=query.list();
		return employeeList;
	}
	public Employee getEmployee(int eid) 
	{
		Employee emp=session.get(Employee.class,eid);
		return emp;
	}
	public void deleteEmployee(Employee emp) 
	{
		transaction.begin();
		session.remove(emp);
		transaction.commit();
	}
	public void updateRecord(Employee empn) 
	{
		Employee empo=getEmployee(empn.getEid());
		transaction.begin();
		empo.setFirstname(empn.getFirstname());
		empo.setLastname(empn.getLastname());
		empo.setPhone(empn.getPhone());
		empo.setEmail(empn.getEmail());
		empo.setDepartment(empn.getDepartment());
		empo.setSalary(empn.getSalary());
		transaction.commit();
	}
}
