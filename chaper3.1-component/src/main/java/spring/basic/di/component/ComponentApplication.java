package spring.basic.di.component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.basic.di.component.service.OrderService;

@SpringBootApplication
public class ComponentApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ComponentApplication.class, args);


		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class);
		//설정 정보를 이용해서 빈 객체를 생성한다.


		OrderService orderService = ctx.getBean(OrderService.class);
		//Bean 객체를 제공한다.

		orderService.order();


	}

}
