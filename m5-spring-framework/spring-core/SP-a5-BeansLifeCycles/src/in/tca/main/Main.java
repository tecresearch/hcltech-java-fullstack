package in.tca.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.tca.bean_life_cycles.BeanLifeCycle;

public class Main {
 
	
	public static void main(String arg[]) {
		String conf="/in/tca/config/beans.xml";
		System.err.println("FIRST: Beans defination loaded from "+conf);
		//use AbstractApplicationContext to register the shutdown hook
		AbstractApplicationContext context=new ClassPathXmlApplicationContext(conf);
		//retrieve the bean from spring container 
		BeanLifeCycle blc_bean=(BeanLifeCycle) context.getBean("LifeCycleBean");
		//use the bean
		blc_bean.printMessage();
        // Close the context to trigger the destroy methods
		context.registerShutdownHook();
		
	}
}
