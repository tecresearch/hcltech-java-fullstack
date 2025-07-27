package com.hcl.hibernate_config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hcl.model.User;

public class HibernateUtil {

	private static final SessionFactory FACTORY = mySessionFactory();

	private static SessionFactory mySessionFactory() {
		try {
			Configuration configuration = new Configuration();

			Properties properties = new Properties();
			properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
			properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hcltech");
			properties.put("hibernate.connection.username", "postgres");
			properties.put("hibernate.connection.password", "Tca@admin");
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.format_sql", "true");

			configuration.setProperties(properties);

			configuration.addAnnotatedClass(User.class);
			return configuration.buildSessionFactory();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	public static SessionFactory getFactory() {
		return FACTORY;
	}

}
