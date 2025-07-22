package com.hcl.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new AnnotationConfigApplicationContext(ProxyConfig.class);
    	Service1 service1=context.getBean(Service1.class);
    	service1.addNumber(12, 10);
    	service1.substractNumber(23, 10);
    	service1.mulNumber(2, 30);
    }
}
