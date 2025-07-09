package in.tecresearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbA8SetterDiApplication {

    public static void main(String[] args) {

       ConfigurableApplicationContext context= SpringApplication.run(SbA8SetterDiApplication.class, args);
       Alien a1=context.getBean(Alien.class);
       a1.code();
    }

}
