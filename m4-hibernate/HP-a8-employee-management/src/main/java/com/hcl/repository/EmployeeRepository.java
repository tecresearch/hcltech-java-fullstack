package com.hcl.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hcl.model.Employee;
import com.hcl.util.HibernateUtil;

public class EmployeeRepository {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.getTransaction();

	public void saveEmployee(Employee employee) {
		transaction.begin();
		session.persist(employee);
		transaction.commit();
		System.out.println("Added successfully");
	}

	public List<Employee> getAllEmployees() {
		transaction.begin();
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.list();
		System.out.println("List of Employee");
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee);

		}
		transaction.commit();
		return employees;
	}

	public Employee getEmployee(int id) {
		transaction.begin();
		Employee employee = session.get(Employee.class, id);
		if (employee != null) {
			System.out.println("Get Employee: " + employee);

		} else {
			System.out.println("Employee not found");
		}
		transaction.commit();
		return employee;
	}

	public void deleteEmployee(int id) {
		transaction.begin();
		Employee employee = session.get(Employee.class, id);
		if (employee != null) {
			session.delete(employee);
			System.out.println("Deleted: " + employee);

		} else {
			System.out.println("Employee not found");
		}
		transaction.commit();

	}

	public void updateEmployee(Employee toBeUpdateEmployee, int id) {
		transaction.begin();
		Employee oldEmployee = session.get(Employee.class, id);
		if (oldEmployee != null) {
			oldEmployee.setFirstname(toBeUpdateEmployee.getFirstname());
			oldEmployee.setEmail(toBeUpdateEmployee.getEmail());
			session.update(oldEmployee);
			System.out.println("Updated");

		} else {
			System.out.println("Employee not found");
		}
		transaction.commit();

	}
}