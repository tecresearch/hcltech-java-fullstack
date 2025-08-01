package com.cetpa.repositories.impl;

import org.hibernate.*;
import org.hibernate.query.Query;
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
	public int getAccountNoByUserId(String userid) 
	{
		Query<Integer> query=session.createQuery("select accountno from Account where userid=:arg",Integer.class);
		query.setParameter("arg",userid);
		int accountno=query.uniqueResult();
		return accountno;
	}
	public int getAmount(int accountno) 
	{
		Query<Integer> query=session.createQuery("select amount from Account where accountno=:arg",Integer.class);
		query.setParameter("arg",accountno);
		int amount=query.uniqueResult();
		return amount;
	}
	public void updateAmount(int amount, int accountno) 
	{
		Account account=session.get(Account.class,accountno);
		transaction.begin();
		account.setAmount(account.getAmount()+amount);
		transaction.commit();
	}
	public String getNameByAccountno(int accountno) 
	{
		Query<String> query=session.createQuery("select concat(firstname,' ',lastname) from Account a join User u on a.userid=u.userid where a.accountno=:arg",String .class);
		query.setParameter("arg",accountno);
		String name=query.uniqueResult();
		return name;
	}
}
