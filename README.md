해당 글은 현재 천천히 공부하면서 정리중입니다. 깔끔하게 정리 후에 브런치 블로그에 발행할 예정입니다..


# Overview
문서 정리 중.


# 1. DI

1장에서는 기본적인 DI 의 개념 및 사용 방법에 대해서 정리한다. 단, @Autowired에 대해서는 2장 부터 정리할려고 한다. 

## 1.1 Bean

#### @Configuration 
해당 클래스를 스프링 설정 클래스로 지정   
  
#### 빈 객체  
스프링이 생성하는 객체  
  
#### @Bean  
- 해당 메서드가 생성한 객체를 스프링이 관리하는 빈 객체로 등록  
- 객체를 생성하고 알맞게 초기화해야 한다.  
  
#### coffeeMaker() 메서드  
빈 객체에 대한 정보를 담고 있는 메서드  
  
#### AnnotationConfigApplicationContext  
- 자바 설정에서 정보를 읽어와 빈 객체를 생성하고 관리  
- ApplicationContext 라는 인터페이스를 구현하였다.  
  
````java  
AnnotationConfigApplicationContext ctx =  
 new AnnotationConfigApplicationContext(AppContext.class);//설정 정보를 이용해서 빈 객체를 생성한다.  
````  
  
#### getBean() 메서드  
- AnnotationConfigApplicationContext 가 자바 설정을 읽어와 생성한 빈 객체를 검색할 때 사용한다.  
- genBean()의 첫번째 파라미터는, @Bean 애노테이션의 메서드 이름은 빈 객체의 이름이다.  
- BeanFactory Interface 에 정의되어 있다.  
  
````java  
Greeter g = ctx.getBean("coffeeMaker", CoffeeMaker.class);  
//Bean 객체를 제공한다.  
````  
  
#### BeanFactory Interface  
객체 생성과 검색에 대한 기능 정의  
  
  
#### ApplicationContext  
빈 객체의 생성, 초기화, 보관 제거 등을 관리한다. 컨테이너 라고도 부른다.   
  
#### 싱글톤 객체  
- 별도 설정을 하지 않은 경우, 스프링은 한 개의 빈 객체만을 생성(싱글톤)  
- @Bean 어노테이션에 대해 한 개의 빈 객체 생성


## 1.2. 의존

#### 의존
DI를 사용하지 않은 의존 방법은, 의존 대상 객체를 직접 생성하는 것이다. 

````java
//CoffeeMakerService 
public class CoffeeMakerService {    
//의존 객체를 직접 생성  
private CoffeeDao coffeeDao = new CoffeeDao();

//Main.java
CoffeeMakerService coffeeMakerService = new CoffeeMakerService();
//의존하는 CoffeeDao의 객체도 함께 생성된다.
````

만약 CoffeeDao를 상속받는 CacheCoffeeDao 로 변경을 해야한다면, CoffeeDao를 생성하는 모든 클래스를 찾아서 아래와 같이 변경해줘야 한다.  
````java
private CoffeeDao coffeeDao = new CacheCoffeeDao();
````
> 좋은 방법이 아니다.


## 1.3. DI 
DI(의존 주입)는 의존하는 객체를 직접 생성하는 대신 의존 객체를 전달 받는 상식이다.

````java
//CoffeeMakerService .java
public class CoffeeMakerService {  
  
    private CoffeeDao coffeeDao;  
  
	//DI(의존 주입)는 의존하는 객체를 직접 생성하는 대신 의존 객체를 전달 받는 방식  
	//생성자를 통해서 의존 객체를 전달받는다.  
	public CoffeeMakerService(CoffeeDao coffeeDao){  
        this.coffeeDao = coffeeDao;  
	  }
//생성자를 통해서 의존 객체를 전달받는다. 

//Main.java
CoffeeDao coffeeDao = new CoffeeDao();  
CoffeeMakerService coffeeMakerService01 = new CoffeeMakerService(coffeeDao);
//의존 객체를 생성자를 통해 주입한다.
````


#### 3. DI 와 의존객체 변경의 유연함

CoffeeDao 를 사용하는 서비스 클래스가 두 개라고 가정하자. 

````java
public class CoffeeMakerService {  
  
    private CoffeeDao coffeeDao;  
	public CoffeeMakerService(CoffeeDao coffeeDao){  
        this.coffeeDao = coffeeDao;  
  }    
}

public class OrderService {  
    private CoffeeDao coffeeDao;  
	public OrderService(CoffeeDao coffeeDao){  
        this.coffeeDao = coffeeDao;  
  }  
}`

//Main.java
CoffeeDao coffeeDao = new CoffeeDao();
CoffeeMakerService coff.. = new CoffeeMakerService(coffeeDao);
OrderService coff.. = new OrderService(coffeeDao);
````

CoffeeDao 를 CacheCoffeeDao로 변경하고자 한다면 아래와 같이 변경하면 된다.
````java
CoffeeDao cacheCoffeeDao = new CacheCoffeeDao();  
CoffeeMakerService coffeeMakerService02 = new CoffeeMakerService(cacheCoffeeDao);
````


## 1.4. Assembler
객체를 생성하고 의존 객체를 주입해주는 클래스를 따로 작성하는 방법. 

````java
//Assembler
public class Assembler{
	private CoffeeDao coffeeDao;
	private CoffeeRegisterService coffeeRegisterService;
    private ORderService orderService;
	
	public Assempler(){
		coffeeDao = new CoffeeDao();
		
		//방법1
		coffeeRegisterService = new CoffeeRegisterSerfvice(coffeeDao);
		
		//방법2
		orderService = new OrderService();
		orderService.setCoffeeDao(coffeeDao);
	}

	public COffeeDao getCoffeeDao();
		return coffeeDao();
	}
	public CoffeeRegisterService getCoffee...(){
		return coffeeRegisterService;
	}
	public OrderService getOrderService(){
		return orderService;
	}
}

//Main.java
Assembler assembler = new Assembler();
CoffeeRegisterService coffsvc = assembler.getCoffeeRegisterService();
````

만약 CoffeeDao 클래스를 상속받은 CacheCoffeeDao 를 사용해야 한다면, 

````java
//Assembler 초기화하는 코드 수정
public Assembler(){
	//coffeeDao = new CoffeeDao();
	coffeeDao = new CacheCoffeeDao();
}

````

> Assembler는 자신이 생성하고 조립한 객체를 리턴하는 메서드를 제공한다.

사실, 스프링이 Assembler 의 역할을 해주는 것이다!!

## 1.5. DI 주입 방법 소개 

4.Assembler 대신 스프링 Injection 방법에 대해서 정리하고, Field DI 를 자제해야 하는 이유 및 다른 주입 방법에 대해서 알아본다.   
  
- Field Injection  
- Constructor  
- Setter   
  
#### Field Injection  
  
간편하게 사용 가능하고, 그동안 내가 많이 사용했던 익숙한 구문이다.   
  
```java  
@Service public class CoffeeService {    
    
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
@RequestMapping("/constructor") @RestController public class constructorController {    
    
  private final CoffeeService coffeeService;    
    
  constructorController(CoffeeService coffeeService){    
        this.coffeeService = coffeeService;    
  }    
    
  @GetMapping    
  public String list(){    
        return coffeeService.toString();    
} }  
```  
#### Setter  
```java  
생략...  
private CoffeeService coffeeService;  
  
@Autowired  
public void setCoffeeService(CoffeeService coffeeservice){  
 this.coffeeService = coffeeservice; }  
생략...  
```  
  
#### Field 주입 방식에 대해서,   
[https://www.vojtechruzicka.com/field-dependency-injection-considered-harmful/](https://www.vojtechruzicka.com/field-dependency-injection-considered-harmful/) 을 참고하자.  Field Inject 는 매우 간결하고 멋있어 보이지만, 이 코드에는 몇가지 문제가 있다.   
  
- Single Responsibility Principle Violation  
- Dependency Hiding  
- DI Container Coupling  
- Immutability  
  
> Setter , Constructor 를 사용하란 얘기이다.  2장에서 다시 다룰 예정이다. 
  
  
#### Constructor DI 를 조금 더 깔끔하게  
롬복을 사용하면 Constructor DI 를 조금 더 깔끔하게 적용할 수 있다.  @RequiredArgsConstructor  를 사용하자. 아래와 같이 생성자에서 주입하는 과정을 생략할 수 있다. Lombok 이 알아서 생성해준다.   
```java  
@RestController @RequestMapping("/lombok") @RequiredArgsConstructor public class lombokController {    
    
  private final CoffeeService coffeeService;    
    
  @GetMapping    
  public String list(){    
        return coffeeService.toString();    
} }  
```  
  
> 혹시... intellij 에서 Lombok 오류가 발생한다면,  Lombok 셋팅을 해주면 해결이 된다.  자세한 건 생략  
  
  
# 참고자료  
  
[http://www.baeldung.com/spring-injection-lombok](http://www.baeldung.com/spring-injection-lombok)  
  
[https://www.vojtechruzicka.com/field-dependency-injection-considered-harmful/](https://www.vojtechruzicka.com/field-dependency-injection-considered-harmful/)  
  
[https://stackoverflow.com/questions/40737720/constructor-injection-vs-field-injection](https://stackoverflow.com/questions/40737720/constructor-injection-vs-field-injection)  
  
[http://crossbreeze.github.io/blog/2014/04/08/field-injection-vs-constructor-injection-with-java-springs-at-autowired/](http://crossbreeze.github.io/blog/2014/04/08/field-injection-vs-constructor-injection-with-java-springs-at-autowired/)  
  
[https://www.petrikainulainen.net/software-development/design/why-i-changed-my-mind-about-field-injection/](https://www.petrikainulainen.net/software-development/design/why-i-changed-my-mind-about-field-injection/)



## 1.6. Bean은 싱글톤 객체



추가 내용

만약 coffeeDao 를 주입하는 곳이 더 있다면?  
coffeeDao() 메서드는 매번 새로운 객체를 생성하지 않는다.  
스프링 컨테이너가 생성한 Bean은 싱글톤 객체이다!!


## 1.7. 설정파일이 여러개인 경우
@Autowired 를 사용할 수 있지만, 그 전에 @Import 어노테이션에 대해서 알아보자. @Import 어노테이션으로, 함께 사용할 설정 클래스를 지정할 수 있다.


## 1.8. 주입 대상 객체를 모두 빈 객체로 설정해야 하는가? 

최범균 님의, 초보 개발자를 위한 스프링5 프로그래밍 입문 을 구매해서 보자. 


# 2. 의존 자동 주입
2장에서는 의존 자동 주입에 대해서 정리한다. 의존 자동 주입에 대해서 공부한다. 

## 2.1 @Autowired

기존에 작성했던 생성자 주입은 아래와 같다. 
````java
private CoffeeDao coffeeDao;  
  
public OrderService(CoffeeDao coffeeDao){  
    this.coffeeDao = coffeeDao;  
}
````

해당 구문을 @Autowired 를 사용하면 의존 자동 주입이 가능하다. 

````java
@Autowired  
private CoffeeDao coffeeDao;

public OrderService(){  
}
````

참고로 예전에는 생성자에도 @Autowired를 적용했었지만, 최근 버전에서는 생략이 가능하다. (어느 버전부터인지는 잘....)
의존 자동 주입을 사용하는 것은 매우 간편하지만, 일부 개발자들은 해당 방법이 아주 좋지는 않다고 한다. 

[https://www.vojtechruzicka.com/field-dependency-injection-considered-harmful/](https://www.vojtechruzicka.com/field-dependency-injection-considered-harmful/)

읽어보면 아래와 같은 문제가 있다고 한다.

-   Single Responsibility Principle Violation
-   Dependency Hiding
-   DI Container Coupling
-   Immutability


#### 참고자료
https://www.baeldung.com/spring-autowire

#### 최범균 님의 조언
자동 주입을 하는 코드와 수동으로 주입하는 코드가 섞여 있으면 주입이 제대로 되지 않았을 때 NullPointerException 원인을 찾는데 시간이 오래 걸릴 수 있다고 한다. 자동 주입을 사용한다면 일관되게 사용하면 좋겠다는 의견이다. 

## 2.2 @Qualifier
지금까지 작성한 코드들은 모두 Bean 이름이 자동으로 설정이 되었다. Bean의 이름은 Bean 을 설정하는 메서드이름을 Bean 이름으로 자동으로 설정한다. 예를 들어서, 

````java
@Configuration  
public class AppContext {  
  
    @Bean  
  public OrderService orderService(){  
        return new OrderService();  
  }
````

@Bean 어노테이션이 붙은 orderService() 메서드에서 orderService 가 Bean 이름이 된다. getBean에서 Bean 이름으로 Bean 객체를 불러온다. 
````
AnnotationConfigApplicationContext ctx =  
      new AnnotationConfigApplicationContext(AppContext.class);  
//설정 정보를 이용해서 빈 객체를 생성한다.  
OrderService orderService = ctx.getBean("orderService", OrderService.class);
````

근데, 만약 자동 주입이 가능한 Bean이 2개 이상이라면 어떤 Bean 을 적용할지 명시적으로 작성해야 한다. 

CafeDao 라는 부모 클래스가 있다고 가정하자. CafeDao 를 상속받는 CoffeeDao 와 JuiceDao 클래스가 있는데, 의존 주입은 부모클래스인 CafeDao 를 선언하였다. 

Bean 설정은 아래와 같다.
````java
@Bean  
public OrderService orderService(){  
    return new OrderService();  
}
@Bean  
public CafeDao coffeeDao(){  
    return new CoffeeDao();
}  
  
@Bean  
public CafeDao juiceDao(){  
    return new JuiceDao();  
}
````

OrderService 클래스에서 CoffeeDao 또는 JuiceDao 를 의존주입하고자 한다.
````
@Autowired  
private CafeDao cafeDao;
````
이렇게 작성하면 아래와 같이 에러 메시지가 나온다. 

This is more than one bean of 'CafeDao' type... CafeDao 타입의 빈이 2개 이상이라서 자동 주입을 못한다고 한다. 이런 경우 명시적으로 Bean 이름을 지정해야 하는데, 아래와 같이 Autowired할 때 @Qualifier 어노테이션을 사용하면 된다.

````java
@Autowired  
@Qualifier("juiceDao")  
private CafeDao cafeDao;
````

#### 만약 빈의 이름을 명시적으로 변경하고자 한다면?
@Bean 설정시 메서드 이름을 하고싶은 걸로 정하면 된다. 그 메서드명이 @Bean의 이름이 되기 때문이다. 하지만, 메서드명이 아니라, @Bean 설정에서 @Qualifier 어노테이션으로 명시적으로 선언할 수도 있다. 
myDao 라는 Bean 을 설정하였다. 
````java
@Bean  
@Qualifier("myDao")  
public CafeDao milkDao(){  
    return new MilkDao();  
}

@Autowired  
@Qualifier("myDao")  
private CafeDao cafeDao;
````


## 2.3 Lombok DI
생성자 주입할 때, 생성자 구문을 생략할 수 있다. 롬복의 @RequiredArgsConstructor  을 사용하면 가능하다. 
````java
@RequiredArgsConstructor  
public class OrderService {  
  
    private final CoffeeDao coffeeDao;  
    
	/* 생략...  
	 public OrderService(CoffeeDao coffeeDao) { this.coffeeDao = coffeeDao; } 
	 */
````

단, 컴파일 오류가 발생하지 않기 위해서는 IDE설정을 바꿔야 한다. IntelliJ 는 아래 캡처를 참고하자.  다른 IDE는 잘 모르겠다. 

#### 참고자료
https://www.baeldung.com/spring-injection-lombok




# 3. 컴포넌트 스캔

## 3.1 컴포넌트 스캔
컴포넌트 스캔은, @Component 어노테이션이 적용되어있는 클래스를 자동으로 빈으로 등록해주는 기능이다. 

OrderService 클래스를 @Component 어노테이션으로 적용해보자. 그리고, AppContext 에 정의된 @Bean 설정을 제거하고, @ComponentScan 으로 스캔할 패키지를 정의한다. 

````java
//OrderService.java
@Component("orderService")  
public class OrderService {

//AppContext.java
@Configuration  
@ComponentScan(basePackages = {"spring.basic.di.component.service"})  
public class AppContext {  
  
    /*  주석처리
	 @Bean public OrderService orderService(){ return new OrderService(); } 
	 */
````

이렇게 하면, @Bean 어노테이션을 사용하지 않고, @Component 로 Bean 객체를 설정할 수 있다. 이렇게 수정하면,  AppContext 에 설정 코드가 줄어든 것을 확인할 수 있다. 

https://www.baeldung.com/spring-bean-annotations

#### Bean 이름 지정
@Component("빈이름") 으로 설정해서 명시적으로 이름을 정의할 수 있다. 따로 정의하지 않는다면, 클래스 이름에서 앞에 한글자만 대문자에서 소문자로 바꿔서 이름으로 설정한다.



## 3.2 @Controller, @Service, @Repository
@Component 어노테이션 외에, 아래 어노테이션도 컴포넌트 스캔의 대상이 된다. 

#### @Repository
DAO or Repository classes usually represent the database access layer in an application, and should be annotated with _@Repository_

#### @Service
The **business logic** of an application usually resides within the service layer – so we’ll use the _@Service_ annotation to indicate 
that a class belongs to that layer:

#### @Controller
_@Controller_ is a class level annotation which tells the Spring Framework that this class serves as a **controller in Spring MVC**:

#### @Configuration
_Configuration_ classes can **contain bean definition methods** annotated with _@Bean_


#### 모두 @Component 의 특수 어노테이션이다.
@Service 어노테이션 소스를 보자. 

````java
@Target({ElementType.TYPE})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
@Component  
public @interface Service {  
  

 * The value may indicate a suggestion for a logical component name, * to be turned into a Spring bean in case of an autodetected component. * @return the suggested component name, if any (or empty String otherwise)  
 */  @AliasFor(annotation = Component.class)  
   String value() default "";  
  
}
````

@Component 어노테이션이 적용되어 있다. 



## 3.3 예제 문제

RestTemplate 를 사용하는 평범한 컴포넌트가 있다고 가정하자. 

````java
//RestTemplate 빈 설정
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate firstRestTemplate() {
        return new RestTemplate() {{
            setRequestFactory(new HttpComponentsClientHttpRequestFactory(HttpClientBuilder
                    .create()
                    .setConnectionManager(new PoolingHttpClientConnectionManager() {{
                        setDefaultMaxPerRoute(50);
                        setMaxTotal(200);
                    }}).build()));
        }};
    }
}

//컴포넌트
@Component  
public class RequestComponent {
	@Autowired
	private RestTemplate restTemplate;
}
````

만약, 두개의 RestTemplate 를 사용하고, 용도에 맞게 RestComponent 에 RestTemplate 를 주입해줘야 하는 상황이 발생한다면, 어떻게 개선하면 좋을까? RestTemplate 를 외부에서 주입해줘야 한다.

RequestComponent 클래스의 @Component 어노테이션을 제거한다. 이제 RequestComponent 는 @Bean 어노테이션으로 따로 설정해야 한다. 이때, 필요에 맞게 RestTemplate 를 주입해주면 된다. 


````java
@Configuration
public class RequestComponentConfig {

    @Bean
    public RequestComponent firstRequestComponent(RestTemplate firstRestTemplate){
        return new RequestComponent(firstRestTemplate);
    }

    @Bean
    public RequestComponent secondRequestComponent(RestTemplate secondRestTemplate){
        return new RequestComponent(secondRestTemplate);
    }
````

컴포넌트를 사용하는 부분에서는 아래와 같이 사용하면 된다.

````java
@Autowired  
@Qualifier("firstRequestComponent")  
private RequestComponent requestComponent;
````

끝!

## 3.4 리스트, 맵 주입

CafeInterface 인터페이스를 구현하는, 두개의 컴포넌트 클래스가 있다고 가정하자. CoffeeComponent 와 BrunchComponent 이다. CafeInterface 인터페이스를 구현하는 모든 Bean 의 리스트를 가져올 수 있을까? 

#### ApplicationContext 
간단한 방법으로는, ApplicationContext 를 활용하면 되겠다. 
아래와 같이 getBeansOfType 메서드를 사용하면 된다. 
````java
@Autowired  
private ApplicationContext applicationContext;
생략
applicationContext.getBeansOfType(CafeInterface.class)...
````

#### List
Bean 리스트만 가져오는 경우는 List< class type > 으로 리스트형으로 주입이 가능하다. 
````java
@Autowired  
private List<CafeInterface> cafeInterfaceList;
````


#### Map
Bean의 이름을 키로 주입받을수도 있다. Map< String, classType > 으로 맵 으로 주입이 가능하다. 

````java
//Bean 이름이 Key  
@Autowired  
private Map<String, CafeInterface> cafeInterfaceMap;
````


# 4. DI in 스프링 부트

사실 스프링부트 환경에서는 지금까지의 소스는 불필요하게 작성된 것이다. 왜냐면, 굳이 스프링 컨테이너 초기화를 안해도 되기 때문이다. 아래 소스가 필요 없었다.
````java
AnnotationConfigApplicationContext ctx =  
      new AnnotationConfigApplicationContext(AppContext.class);
```` 

왜냐하면 스프링부트 초기에 실행될 때  자동으로 컨테이너를 초기하고, 설정파일을 찾아서 빈에 등록해준다.

> SpringApplication.run

콘솔로그를 보자. 


캡쳐화면



중요!!
https://www.slideshare.net/sbcoba/2016-deep-dive-into-spring-boot-autoconfiguration-61584342



## 4.1 ...

SpringApplication 클래스를 보면 

````java
public ConfigurableApplicationContext run(String... args)
생략...

refreshContext(context);
````




https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-using-springbootapplication-annotation.html

https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-structuring-your-code.html


## 4.2 SpringApplication . run


