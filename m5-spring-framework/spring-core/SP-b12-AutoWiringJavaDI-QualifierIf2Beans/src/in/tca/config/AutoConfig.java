package in.tca.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.tca.model.Client;
import in.tca.model.Task;
import in.tca.model.TaskStatus;
import in.tca.model.User;

@Configuration
public class AutoConfig {
 
	@Bean("statusId")
	public TaskStatus createStatusObject() {
		TaskStatus status=new TaskStatus();
		status.setImportant(true);
		status.setCompleted(false);
		return status;
	}
	@Bean("taskId1")
	public Task createTaskObject1(){
		Task task=new Task();
		task.setTid(101);
		task.setTitle("Spring Framework");
		task.setDescription("TaskObject1: Spring Frame Having : Spring-core,Spring-contex,Spring-expression,Spring-logging-common,Spring-jdbc,Spring-orm,Spring-jpa etc.");
//		task.setStatus(createStatusObject());//manually inject or @Autowired
		return task;
	}
	
	@Bean("taskId2")
	public Task createTaskObject2(){
		Task task=new Task();
		task.setTid(101);
		task.setTitle("Spring Framework");
		task.setDescription("TaskObject2: Spring Frame Having : Spring-core,Spring-contex,Spring-expression,Spring-logging-common,Spring-jdbc,Spring-orm,Spring-jpa etc.");
//		task.setStatus(createStatusObject());//manually inject or @Autowired
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
//		user.setTask(createTaskObject1());//manually Dependency Injection
//		user.setTask(createTaskObject2());//manually Dependency Injection or if more than two object of same class than use @Qualifier with @Autowired
		return user;
	}
	
	@Bean("clientId")
	public Client createClientObject() {
		Client client=new Client();
		client.setName("Brijesh Nishad");
//		client.setTask(createTaskObject2());//manually Dependency Injection or if more than two object of same class than use @Qualifier with @Autowired
		return client;
	}
}
