package com.hcl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hcl.hibernate_config.HibernateUtil;
import com.hcl.model.Employee;

/**
 * Hello world!
 *this cacche required when application is creating and using more than one hibernate session 
 *This cache will be associated with hibernate session factory 
 *Objects kept into second level cache can be accessed by every hibernate session
 *
 *how to use second level cache
 *
 *1)configure dependency in pom.xml
 *2)configure implementation of this cache into cfg file and enable it
 *3)set cache concurrancy strategy into entity class
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory=HibernateUtil.getFactory();
        Session session1=factory.openSession();
		Session session2=factory.openSession();
		Session session3=factory.openSession();
		//Accessing object first time from sesion1 
		Employee e1=session1.get(Employee.class,1);
		System.out.println(e1);//check own means first level cache session cache if not found then check second 
		session1.evict(e1);//remove from the cache
		//Accessing same object second time from sesion2 
		Employee e2=session2.get(Employee.class,1);//check own means first level cache session cache if not found then check second 
		System.out.println(e2);

		//Accessing same object third time  from sesion3
		Employee e3=session3.get(Employee.class,1);//check own means first level cache session cache if not found then check second 
		System.out.println(e3);
      
    }
}
