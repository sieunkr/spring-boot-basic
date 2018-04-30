package spring.basic.aop.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(* spring..*Service.*(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("Before: " + joinPoint);
    }

    @After("execution(* spring..*Service.*(..))")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("After: " + joinPoint);
    }

    @AfterReturning("execution(* spring..*Service.*(..))")
    public void logAfterReturn(JoinPoint joinPoint) {
        System.out.println("Completed: " + joinPoint);
    }
}
