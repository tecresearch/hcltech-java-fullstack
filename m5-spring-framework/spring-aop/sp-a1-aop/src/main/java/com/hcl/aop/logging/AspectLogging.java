package com.hcl.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectLogging {

    @Before("execution(* com.hcl.aop.model.User.Display(..))")
    public void commonLog1() {
    	System.out.println("____________________________________________________________________");
        System.out.println("This line executed before calling display");
    	System.out.println("____________________________________________________________________");
    }

    @After("execution(* com.hcl.aop.model.User.Display(..))")
    public void commonLog2() {
    	System.out.println("____________________________________________________________________");
        System.out.println("This line executed after calling display");
    	System.out.println("____________________________________________________________________");
    }

    @AfterReturning(pointcut = "execution(* com.hcl.aop.model.User.toString(..))", returning = "result")
    public void commonLog3(JoinPoint joinPoint, Object result) {
    	System.out.println("____________________________________________________________________");
        System.out.println("After returning: " + result);
        System.out.println("After return toString value");
    	System.out.println("____________________________________________________________________");
    }


    @AfterThrowing(pointcut = "execution(* com.hcl.aop..*(..))", throwing = "ex")
    public void commonLog4(org.aspectj.lang.JoinPoint joinPoint, Throwable ex) {
    	System.out.println("____________________________________________________________________");
        System.out.println("Exception occurred in method: " + joinPoint.getSignature().getName());
        System.out.println("Exception message: " + ex.getMessage());
    	System.out.println("____________________________________________________________________");
    }


    @Around("execution(* com.hcl.aop.model.User.Display(..))")
    public Object commonLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
    	System.out.println("____________________________________________________________________");
        System.out.println("Around advice: Before method " + joinPoint.getSignature().getName());
    	System.out.println("____________________________________________________________________");
        Object result = joinPoint.proceed(); // Proceed with the actual method
        System.out.println("Around advice: After method " + joinPoint.getSignature().getName());
    	System.out.println("____________________________________________________________________");
        return result;
    }
}
