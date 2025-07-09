package in.tecresearch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SbA3CreateBeansClrImpl1Application implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(SbA3CreateBeansClrImpl1Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        String msg=createObjMyClass().printMSG("Bean object created");
        System.out.println(msg);
    }
    @Bean
    public MyClass createObjMyClass(){
        return new MyClass();
    }
}
