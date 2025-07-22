package com.hcl.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AspectAop {

    @Before("execution(* com.hcl.aop.Service1.*(..))")
    public void headerLog() {
        System.out.println("🔐 Must be a logged-in user");
    }

    @After("execution(* com.hcl.aop.Service1.*(..))")
    public void footerLog() {
        System.out.println("✅ Execution completed");
    }

    @Around("execution(* com.hcl.aop.Service1.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("⏳ Around - Before method: " + joinPoint.getSignature());
        Object result = joinPoint.proceed(); // Proceed with the actual method
        System.out.println("⏹️ Around - After method: " + joinPoint.getSignature());
        return result;
    }

    @AfterReturning(pointcut = "execution(* com.hcl.aop.Service1.*(..))", returning = "result")
    public void afterReturningAdvice(Object result) {
        System.out.println("🎉 Method returned successfully with result: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.hcl.aop.Service1.*(..))", throwing = "ex")
    public void afterThrowingAdvice(Exception ex) {
        System.out.println("❌ Exception caught in method: " + ex.getMessage());
    }
}
