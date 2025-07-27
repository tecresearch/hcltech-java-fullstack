package com.hcl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.hcl.hibernate_config.HibernateUtil;
import com.hcl.model.User;

public class App6 {
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
			Query query = session.createQuery("select name from User where id=:arg");
			query.setParameter("arg", 15);
			String name=(String) query.uniqueResult();
			System.out.println(name);
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}
}
