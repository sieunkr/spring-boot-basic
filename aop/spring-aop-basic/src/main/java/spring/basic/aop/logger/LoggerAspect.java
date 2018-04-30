package spring.basic.aop.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import spring.basic.aop.annotation.LogAspect;

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

        //파라미터 확인
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg: signatureArgs) {
            System.out.println("Arg: " + signatureArg);
        }

        System.out.println("Completed: " + joinPoint);
    }





    @Pointcut("@annotation(spring.basic.aop.annotation.LogAspect)")
    public void getLogAspect(){}

    @Before("getLogAspect()")
    public void initTarget(JoinPoint joinPoint){


        System.out.println("어노테이션으로 체크");
    }



}
