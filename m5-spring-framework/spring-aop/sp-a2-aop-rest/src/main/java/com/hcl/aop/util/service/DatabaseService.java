package com.hcl.aop.util.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Autowired 
    private SessionFactory sessionFactory;

    public void testConnection() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            if (session.isConnected()) {
                System.out.println("✅ Connection to the database was successful!");
            } else {
                System.out.println("❌ Failed to connect to the database.");
            }

            transaction.commit();
        }
    }
}
