package com.hcl.spring_di;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hcl.setter.Address;
import com.hcl.setter.Employee;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	String xmlInstructionLocation="setter_bean_config.xml";
    	
    	System.out.println("Spring will read this location to create bean/object: "+xmlInstructionLocation);
    	
    	ApplicationContext container1=new ClassPathXmlApplicationContext(xmlInstructionLocation);
    	
    	/*______________
    	 * addr1
    	 * addr2
    	 * _____________
    	 */
    	
//		Address a1=new Address();
    	Address a1=(Address)container1.getBean("addr1");
		
//        a1.setAddressLine1("Kashi");
//        a1.setCity("Varanasi");
//        a1.setState("UP");
        System.out.println(a1);
        
//        Address a2=new Address();
//        a2.setAddressLine1("Kashi");
//        a2.setCity("Varanasi");
//        a2.setState("UP");
//        a2.setCountry("India");
        
        Address a2=(Address)container1.getBean("addr2");
        System.out.println("_____________________________________________");
        System.out.println(a2);
    
//        
//        Employee e1=new Employee();
//        
//        
//        e1.setId(101);
//        e1.setName("Brijesh Nishad");
//        e1.setAddress(a1);
//        
        Employee e1=(Employee)container1.getBean("emp1");
        System.out.println("_____________________________________________");
        System.out.println(e1);
        Employee e2=(Employee)container1.getBean("emp2");
        System.out.println("_____________________________________________");
        System.out.println(e2);
        System.out.println("_____________________________________________");
    }
}
