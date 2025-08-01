package com.cetpa.repositories.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.cetpa.models.TransactionInfo;
import com.cetpa.repositories.TransactionRepository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository 
{
	private Session session;
	private Transaction transaction;
	public TransactionRepositoryImpl(SessionFactory sessionFactory)
	{
		session=sessionFactory.openSession();
		transaction=session.getTransaction();
	}
	public void saveTransaction(TransactionInfo transactionInfo) 
	{
		transaction.begin();
		session.persist(transactionInfo);
		transaction.commit();
	}
}
