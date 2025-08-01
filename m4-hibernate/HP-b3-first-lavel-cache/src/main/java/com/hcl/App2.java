package com.hcl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
 

import com.hcl.hibernate_config.HibernateUtil;
import com.hcl.model.Employee;

/**
 * Hello world!
 *
 */
public class App2 
{
    public static void main( String[] args )
    {
        SessionFactory factory=HibernateUtil.getFactory();
        Session session=factory.openSession();

    //Accessing object first time 
    		Employee e1=session.get(Employee.class,1);
    		System.out.println(e1);//hit the query
    		
    		//Accessing same object second time 
    		Employee e2=session.get(Employee.class,1);
    		System.out.println(e2);//get from first level cache
    		//Accessing same object third time 
    		Employee e3=session.get(Employee.class,1);
    		System.out.println(e3);//get from first level cache
    }
}
