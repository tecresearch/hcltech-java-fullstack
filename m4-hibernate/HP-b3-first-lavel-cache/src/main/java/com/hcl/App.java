package com.hcl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hcl.hibernate_config.HibernateUtil;
import com.hcl.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory=HibernateUtil.getFactory();
        Session session=factory.openSession();
        Transaction transaction=session.getTransaction();
        transaction.begin();
      Employee emp=new  Employee(   "Brijesh Nishad",  "bnlv1212@gmail.com",  22,  "Hcltech");
      session.save(emp);
      session.persist(emp);
      transaction.commit();
    }
}
