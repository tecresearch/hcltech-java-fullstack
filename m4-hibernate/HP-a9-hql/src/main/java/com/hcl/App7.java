package com.hcl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.hcl.hibernate_config.HibernateUtil;
import com.hcl.model.User;

public class App7 {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getFactory();
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();

			if (session.isConnected()) {
				System.out.println("Connection to the database was successful!");
			} else {
				System.out.println("Failed to connect to the database.");
			}
			System.out.println("Feteched data  : ");
			// Create the query
			Query query = session.createQuery("update User set name = concat(name, :arg1) where id = :arg2");
			query.setParameter("arg1", " Updated");
			query.setParameter("arg2", 14);

			// Execute the update
			int result = query.executeUpdate();
			// Commit the transaction
			transaction.commit();
			System.out.println("Updated: "+session.get(User.class, 14));
			
			
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}
}
