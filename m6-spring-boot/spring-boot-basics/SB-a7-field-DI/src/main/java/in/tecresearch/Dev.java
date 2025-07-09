package in.tecresearch;

import com.fasterxml.jackson.annotation.JacksonInject;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //Spring will manage this bean
public class Dev {

    @Resource//avoid @Autowired and @Resource is part of Java's standard library, making it independent of Spring
    @Qualifier("laptop")
    private  Computer computer;
    public void build(){
        computer.compile();
        System.out.println("Building your code....");
        computer.completed();
    }
}
