package spring.basic.di.chapter01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Chapter01Application {

	public static void main(String[] args) {
		//SpringApplication.run(Chapter01Application.class, args);


		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class);
		//설정 정보를 이용해서 빈 객체를 생성한다.
		CoffeeMaker coffeeMaker = ctx.getBean("coffeeMaker", CoffeeMaker.class);
		//Bean 객체를 제공한다.
		coffeeMaker.blew("라떼");


		//In fact, Spring Boot automatically registers every servlet-related bean to the container.
		//사실, 스프링 부트에서는, 스프링 컨테이너에 Bean 객체를 자동으로 등록해준다.
	}

}
