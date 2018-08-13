# 1장. Bean 생성

#### @Configuration 해당 클래스를 스프링 설정 클래스로 지정   
  
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


# 2장. 의존

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


# 3. DI 
DI(의존 주입)는 의존하는 객체를 직접 생성하는 대신 의존 객체를 전달 받는 상식이다.

````java
//CoffeeMakerService .java
public class CoffeeMakerService {  
  
    private CoffeeDao coffeeDao;  
  
	//DI(의존 주입)는 의존하는 객체를 직접 생성하는 대신 의존 객체를 전달 받는 방식  
	//생성자를 통해서 의존 객체를 전달받는다.  public CoffeeMakerService(CoffeeDao coffeeDao){  
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


# 4. Assembler
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

Assembleer는 자신이 생성하고 조립한 객체를 리턴하는 메서드를 제공한다.