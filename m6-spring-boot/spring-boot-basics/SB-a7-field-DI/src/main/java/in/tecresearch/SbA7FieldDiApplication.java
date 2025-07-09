package in.tecresearch;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbA7FieldDiApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context= SpringApplication.run(SbA7FieldDiApplication.class, args);
        Dev dev=context.getBean(Dev.class);
        dev.build();
    }



}
