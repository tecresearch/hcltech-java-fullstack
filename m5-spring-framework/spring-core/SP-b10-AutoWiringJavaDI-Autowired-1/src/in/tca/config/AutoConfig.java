package in.tca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.tca.model.Task;
import in.tca.model.User;

@Configuration
public class AutoConfig {
 
	@Bean("taskId")
	public Task createTaskObject() {
		Task task=new Task();
		task.setTid(101);
		task.setTitle("Spring Framework");
		task.setDescription("Spring Frame Having : Spring-core,Spring-contex,Spring-expression,Spring-logging-common,Spring-jdbc,Spring-orm,Spring-jpa etc.");
		
		return task;
	}
	@Bean("userId")
	public User createUserObject() {
		User user=new User();
		user.setUid(1001);
		user.setName("Brijesh Nishad");
		user.setUsername("mrjacks");
		user.setEmail("bnlv1212@gmail.com");
		user.setPassword("12344");
//		user.setTask(createTaskObject());//manually Dependency Injection or use @Autowired and can remove the getters/setters
		return user;
	}
	
}
