package in.tca.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.tca.beans.Student;
import in.tca.resources.SpringConfig;

public class Main {

	public static void main(String[] args) {
		
		
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Student student=(Student)context.getBean("stdObj1");
		String data=student.toString();
		System.out.println(data);

	}

}
