package com.hcl.setup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hcl.setup.model.User;

 
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Configuration hibernateContext=new Configuration().configure("hibernate.cfg.xml");
       
       SessionFactory factory=hibernateContext.buildSessionFactory();
       
       Session session=factory.openSession();
       Transaction transaction=session.getTransaction();
       
   
       transaction.begin();
       session.save(new User(131,"Brijesh","Nishad"));
       transaction.commit();
       
       System.out.println("Users Saved successfully");
       
   
    }
}
