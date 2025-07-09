package in.tca.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.tca.beans.Student;

@Configuration
public class SpringConfig {
	
	@Bean("stdObj1")
	public Student createStudentBean1() {
		Student std=new Student();
		
		std.setId(01);
		std.setFirstName("Brijesh ");
		std.setLastName("Nishad");
		std.setDob("14/01/2002");
		std.setEmail("bnlv1212@gmail.com");
		std.setPassword(1124);
		std.setPhone("9506563150");
		std.setAddhar("490013984091");
		std.setAddress("Varanasi UP 221104");
		
		return std;
	}
	
	@Bean("stdObj2")
	public Student createStudentBean2() {
		Student std=new Student();
		
		std.setId(02);
		std.setFirstName("TCA ");
		std.setLastName("Admin");
		std.setDob("14/01/2002");
		std.setEmail("tecresearch.in@gmail.com");
		std.setPassword(1124);
		std.setPhone("9506563150");
		std.setAddhar("490013984091");
		std.setAddress("Greater Noida UP 201310");
		
		return std;
	}
	
}
