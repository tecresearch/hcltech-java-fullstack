package com.hcl.employee.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
		session.persist(employee);
		transaction.commit();

	}

	@Override
	public void update(Employee employee) {
		transaction.begin();
		session.update(employee);
		transaction.commit();

	}

	@Override
	public void delete(Employee employee) {
		transaction.begin();
		session.delete(employee);
		transaction.commit();

	}

	@Override
	public Employee get(int id) {
		transaction.begin();
		Employee employee = session.get(Employee.class, id);
		transaction.commit();
		return employee;
	}

}
