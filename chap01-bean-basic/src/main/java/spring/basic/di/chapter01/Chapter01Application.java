package spring.basic.di.chapter01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Chapter01Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Chapter01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class);
		//설정 정보를 이용해서 빈 객체를 생성한다.

		CoffeeMaker coffeeMaker = ctx.getBean("coffeeMaker", CoffeeMaker.class);
		//Bean 객체를 제공한다.

		coffeeMaker.blew("라떼");

	}
}
