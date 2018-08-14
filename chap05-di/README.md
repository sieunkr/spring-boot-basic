#5. DI 주입 방법

## Overview
Injection 방법에 대해서 정리하고, Field DI 를 자제해야 하는 이유 및 다른 주입 방법에 대해서 알아본다. 

- Field Injection
- Constructor
- Setter 

#### Field Injection

간편하게 사용 가능하고, 그동안 내가 많이 사용했던 익숙한 구문이다. 

```java
@Service  
public class CoffeeService {  
  
    public String toString(){  
        return "커피 한잔 하실까요?";  
  }  
  
}
``` 
@Autowired 를 활용하여 아래와 같이 깔끔하게 선언 및 사용이 가능하다. 

```java
@RequestMapping("/field")  
@RestController  
public class fieldController {  
  
  @Autowired  
  private CoffeeService coffeeService;  
  
  @GetMapping  
  public String list(){  
        return coffeeService.toString();  
  }  
}
```



#### Constructor

생성자에 의해 주입하는 경우에는 아래와 같이 final 필드로 선언한다.  예전에는 생성자에 @Autowired 를 적용했었지만, 그 이후 버전에서는 생략이 가능하다. 

```java
@RequestMapping("/constructor")  
@RestController  
public class constructorController {  
  
  private final CoffeeService coffeeService;  
  
  constructorController(CoffeeService coffeeService){  
        this.coffeeService = coffeeService;  
  }  
  
  @GetMapping  
  public String list(){  
        return coffeeService.toString();  
  }  
}
```
#### Setter
```java
생략...
private CoffeeService coffeeService;

@Autowired
public void setCoffeeService(CoffeeService coffeeservice){
	this.coffeeService = coffeeservice;	
}
생략...
```

#### Field 주입 방식에 대해서, 

[https://www.vojtechruzicka.com/field-dependency-injection-considered-harmful/](https://www.vojtechruzicka.com/field-dependency-injection-considered-harmful/) 을 참고하자.  Field Inject 는 매우 간결하고 멋있어 보이지만, 이 코드에는 몇가지 문제가 있다. 

- Single Responsibility Principle Violation
- Dependency Hiding
- DI Container Coupling
- Immutability

#### 자 그래서, 왜만하면 Setter , Constructor 를 사용하란 얘기이다.


# Constructor DI 를 조금 더 깔끔하게
롬복을 사용하면 Constructor DI 를 조금 더 깔끔하게 적용할 수 있다.  @RequiredArgsConstructor  를 사용하자. 아래와 같이 생성자에서 주입하는 과정을 생략할 수 있다. Lombok 이 알아서 생성해준다. 
```java
@RestController  
@RequestMapping("/lombok")  
@RequiredArgsConstructor  
public class lombokController {  
  
  private final CoffeeService coffeeService;  
  
  @GetMapping  
  public String list(){  
        return coffeeService.toString();  
  }  
}
```

> 혹시... intellij 에서 Lombok 오류가 발생한다면,  Lombok 셋팅을 해주면 해결이 된다.  자세한 건 생략


# 참고자료

[http://www.baeldung.com/spring-injection-lombok](http://www.baeldung.com/spring-injection-lombok)

[https://www.vojtechruzicka.com/field-dependency-injection-considered-harmful/](https://www.vojtechruzicka.com/field-dependency-injection-considered-harmful/)

[https://stackoverflow.com/questions/40737720/constructor-injection-vs-field-injection](https://stackoverflow.com/questions/40737720/constructor-injection-vs-field-injection)

[http://crossbreeze.github.io/blog/2014/04/08/field-injection-vs-constructor-injection-with-java-springs-at-autowired/](http://crossbreeze.github.io/blog/2014/04/08/field-injection-vs-constructor-injection-with-java-springs-at-autowired/)

[https://www.petrikainulainen.net/software-development/design/why-i-changed-my-mind-about-field-injection/](https://www.petrikainulainen.net/software-development/design/why-i-changed-my-mind-about-field-injection/)
