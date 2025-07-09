package in.tecresearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbA9ConstructorDiAutoWiringApplication {

    public static void main(String[] args) {
    ConfigurableApplicationContext context= SpringApplication.run(SbA9ConstructorDiAutoWiringApplication.class, args);
    Dev d1=context.getBean(Dev.class);
    d1.code();
    }

}
