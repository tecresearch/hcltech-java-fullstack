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
public class App3 
{
    public static void main( String[] args )
    {
        SessionFactory factory=HibernateUtil.getFactory();
        Session session=factory.openSession();
        Transaction transaction=session.getTransaction();
        transaction.begin();
       
    //Accessing object first time 
    		Employee e1=session.get(Employee.class,1);
    		System.out.println(e1);//hit database 
    		session.evict(e1);//remove object from cache
    		//Accessing same object second time 
    		Employee e2=session.get(Employee.class,1);
    		System.out.println(e2);//hit database 

    		//Accessing same object third time 
    		Employee e3=session.get(Employee.class,1);
    		System.out.println(e3);//not hit database due to first level cache
    }
}
