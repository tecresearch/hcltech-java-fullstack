package com.hcl.aop;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hcl.aop.model.User;

@SpringBootApplication
public class SpA1AopApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpA1AopApplication.class, args);
        
        User user = context.getBean(User.class);
        user.setId(101);
        System.out.println("User ID: " + user.getId());
        
        user.setName("Brijesh Nishad");
        System.out.println("User Name: " + user.getName());
        
        Map<String, String> map = new LinkedHashMap<>();
        map.put("Village", "Pari Chowk");
        map.put("District", "Greater Noida");
        map.put("State", "Uttar Pradesh");
        map.put("Country", "India");
        
        user.setAddress(map);
        user.toString();
        
        user.Display(); // Make sure this method exists in User class
        
        try {
            user.throwException();
        } catch (Exception e) {
            System.out.println("Caught exception in main: " + e.getMessage());
        }

    }
}
