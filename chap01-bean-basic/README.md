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
				new AnnotationConfigApplicationContext(AppContext.class);
//설정 정보를 이용해서 빈 객체를 생성한다.
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

