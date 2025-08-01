package com.cetpa.repository;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.cetpa.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository 
{
	private Session session;
	private Transaction transaction;
	public EmployeeRepositoryImpl(SessionFactory sessionFactory)
	{
		session=sessionFactory.openSession();
		transaction=session.getTransaction();
	}
	public void saveRecord(Employee employee) 
	{
		transaction.begin();
		session.save(employee);
		transaction.commit();
	}
	public List<Employee> findAll() 
	{
		Query<Employee> query=session.createQuery("from Employee",Employee.class);
		return query.list();
	}
	public void deleteRecord(int eid) 
	{
		Employee employee=session.get(Employee.class,eid);
		transaction.begin();
		session.remove(employee);
		transaction.commit();
	}
	public Employee getRecord(int eid) 
	{
		Employee employee=session.get(Employee.class,eid);
		return employee;
	}
	public void updateRecord(Employee employeeo, Employee employeen) 
	{
		transaction.begin();
		employeeo.setFirstname(employeen.getFirstname());
		employeeo.setLastname(employeen.getLastname());
		employeeo.setPhone(employeen.getPhone());
		employeeo.setEmail(employeen.getEmail());
		employeeo.setDepartment(employeen.getDepartment());
		employeeo.setSalary(employeen.getSalary());
		transaction.commit();
	}
}
