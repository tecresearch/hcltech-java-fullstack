package com.hcl.employee.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hcl.employee.model.Employee;
import com.hcl.employee.repository.EmployeeRepository;


public class EmployeeRepositoryImpl implements EmployeeRepository {
	private Session session;
	private Transaction transaction;

	public EmployeeRepositoryImpl() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		if (sessionFactory != null) {
			System.out.println("Hibernate configured successfully");
			this.session = sessionFactory.openSession();
			this.transaction = this.session.getTransaction();

		}

	}

	@Override
	public void save(Employee employee) {
		transaction.begin();
		session.save(employee);
		transaction.commit();
	}

	@Override
	public void persist(Employee employee) {
		transaction.begin();
		session.save(employee);
		transaction.commit();

	}

	@Override
	public void update(Employee toBeUpdated, int id) {
		transaction.begin();

		Employee oldEmployee = session.get(Employee.class, id);
		oldEmployee.setName(toBeUpdated.getName());
		oldEmployee.setEmailId(toBeUpdated.getEmailId());
		oldEmployee.setAge(toBeUpdated.getAge());
		oldEmployee.setCompany(toBeUpdated.getCompany());
		session.update(oldEmployee);
		transaction.commit();

	}

	@Override
	public void delete(int id) {
		transaction.begin();

		Employee toBeDeleted = session.get(Employee.class, id);
		session.delete(toBeDeleted);
		transaction.commit();

	}

	@Override
	public Employee get(int id) {
		transaction.begin();
		Employee employee = session.get(Employee.class, id);
		transaction.commit();
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		transaction.begin();
		Query<Employee> query=session.createQuery("FROM Employee",Employee.class);
		 List<Employee> data=query.list();
		return data;
	}

}
