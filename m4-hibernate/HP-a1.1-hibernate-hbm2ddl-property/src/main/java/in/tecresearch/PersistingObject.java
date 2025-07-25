package in.tecresearch;

import in.tecresearch.model.Product;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class PersistingObject {
	public static void main(String[] args) {
		try {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = factory.openSession();
			Transaction tr = session.getTransaction();
			tr.begin();
			session.persist(new Product(01123, "Laptop", "HP", 50000));
			session.persist(new Product(1222, "Mouse", "Logitech", 700));
			session.clear();
			session.persist(new Product(1022, "Mouse", "Logitech", 700));
			session.persist(new Product(1032, "Printer", "Dell", 5000));
			tr.commit();
			System.out.print("Product added successfully");

			tr.begin();
			Query<Product> query = session.createQuery("from Product", Product.class);
			List<Product> products = query.list();
			for (Product p : products) {
				System.out.println(p);
			}
			factory.close();
			 
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}

	}
}
