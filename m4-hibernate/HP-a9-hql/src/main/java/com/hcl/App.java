package com.hcl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.hcl.hibernate_config.HibernateUtil;
import com.hcl.model.User;
 
public class App {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getFactory();
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();

			if (session.isConnected()) {
				System.out.println("Connection to the database was successful!");
			} else {
				System.out.println("Failed to connect to the database.");
			}

			User user1 = new User();
			user1.setName(" Brijesh Nishad");
			User user2 = new User();
			user2.setName(" Kishad Nishad");
			User user3 = new User();
			user3.setName(" Santosh Kumar Gond");

			session.persist(user1);
			session.persist(user2);
			session.persist(user3);

			transaction.commit();

			System.out.println("data inseted: ");

			 
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}
}
