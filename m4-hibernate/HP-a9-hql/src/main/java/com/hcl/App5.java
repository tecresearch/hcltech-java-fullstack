package com.hcl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.hcl.hibernate_config.HibernateUtil;
import com.hcl.model.User;

public class App5 {
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
			Query<User> query = session.createQuery("from User", User.class);
			query.setFirstResult(2);
			query.setMaxResults(5);
			List<User> userList = query.list();
			userList.forEach(user -> {
				System.out.print(user.getId() + ": ");
				System.out.println(user.getName());
			});
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}
}
