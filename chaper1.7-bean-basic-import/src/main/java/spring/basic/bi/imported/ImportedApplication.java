package spring.basic.bi.imported;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ImportedApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ImportedApplication.class, args);

		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppcontextImport.class);
		//설정 정보를 이용해서 빈 객체를 생성한다.
		OrderService orderService = ctx.getBean("orderService", OrderService.class);
		//Bean 객체를 제공한다.

		System.out.println(orderService.order());
	}
}
