package com.hcl.aop.util.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ConnectionAspect {

    @Before("execution(* com.hcl.aop.util.service.DatabaseService.testConnection(..))")
    public void beforeConnectionTest() {
        System.out.println("🔍 Starting database connection test...");
    }

    @After("execution(* com.hcl.aop.util.service.DatabaseService.testConnection(..))")
    public void afterConnectionTest() {
        System.out.println("✅ Finished database connection test.");
    }

    @AfterThrowing(pointcut = "execution(* com.hcl.aop.util.service.DatabaseService.testConnection(..))", throwing = "ex")
    public void handleException(Throwable ex) {
        System.out.println("❌ Exception occurred: " + ex.getMessage());
        ex.printStackTrace();
    }
}
