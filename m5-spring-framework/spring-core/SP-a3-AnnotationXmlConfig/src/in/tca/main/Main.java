package in.tca.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.tca.beans.Student;

public class Main {

	public static void main(String[] args) {
		
		String res_path="/in/tca/resources/applicationContext.xml";
		ApplicationContext context=new ClassPathXmlApplicationContext(res_path);
		
		Student std=(Student)context.getBean("student");
		String data=std.toString();
		System.out.println(data);
	}

}
