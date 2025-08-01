package com.cetpa.repositories.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
	public List<TransactionInfo> getList(int accountno) 
	{
		Query<TransactionInfo> query=session.createQuery("from TransactionInfo where (fromaccount=:arg1 and toaccount=:arg1) or (fromaccount=:arg1 and type='Debit') or (toaccount=:arg2 and type='Credit')",TransactionInfo.class);
		query.setParameter("arg1",accountno);
		query.setParameter("arg2",accountno);
		return query.list();
	}
}
