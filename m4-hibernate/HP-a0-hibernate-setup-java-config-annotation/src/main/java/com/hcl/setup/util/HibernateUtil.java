package com.hcl.setup.util;

 
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
import com.hcl.setup.model.User;

public class HibernateUtil {
	private static final SessionFactory SESSION_FACTORY=myBuildSessionFactory();

	private static SessionFactory myBuildSessionFactory() {
		 try {
	            Configuration hibernateContext = new Configuration();
	            // Set Hibernate properties
	            Properties properties = new Properties();
	            properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
	            properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
	            properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hcltech");
	            properties.put("hibernate.connection.username", "postgres");
	            properties.put("hibernate.connection.password", "Tca@admin");
	            properties.put("hibernate.hbm2ddl.auto", "update");
	            properties.put("hibernate.show_sql", "true");
	            properties.put("hibernate.format_sql", "true");
	            hibernateContext.setProperties(properties);

	            // Add annotated classes
	            hibernateContext.addAnnotatedClass(User.class);
	            

	            return hibernateContext.buildSessionFactory();
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	
	
	
}
