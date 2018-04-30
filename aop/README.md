
# AOP

AOP 는 Aspect Orient Programming 으로, 관점 지향 프로그래밍을 뜻한다. 

## 사용 예

 - 성능 검사
 - 트랜잭션 처리
 - 로깅
 - 예외 반환

## 구성 요소

 - JoinPoint
 - PointCut
 - Advice


## 샘플

```java
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
}
```

