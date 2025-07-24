package com.hcl.setup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hcl.setup.model.User;
import com.hcl.setup.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Transaction transaction=null;
		Session session=null;
		if (factory != null) {
			session= factory.openSession();
			 transaction = session.getTransaction();
			System.out.println("Hibernate configured successfully");
			
		} else {
			System.err.println("Failed: Hibernate unable to configured ");

		}
		
	transaction.begin();
	User user1=new User(12,"Brijesh","Nishad");
	session.save(user1);
	session.clear();
	User user2=new User(1,"Brijesh","Nishad");
	session.save(user2);
	transaction.commit();
	System.out.println("User saved successfully");
		
		
		

	}
}
