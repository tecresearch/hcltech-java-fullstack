package com.cetpa.repositories.impl;

import org.hibernate.*;
import org.springframework.stereotype.Repository;

import com.cetpa.models.Account;
import com.cetpa.repositories.AccountRepository;


@Repository
public class AccountRepositoryImpl implements AccountRepository
{
	private Session session;
	private Transaction transaction;
	public AccountRepositoryImpl(SessionFactory sessionFactory)
	{
		session=sessionFactory.openSession();
		transaction=session.getTransaction();
	}
	public void persistAccount(Account account) 
	{
		transaction.begin();
		session.persist(account);
		transaction.commit();
	}
}
