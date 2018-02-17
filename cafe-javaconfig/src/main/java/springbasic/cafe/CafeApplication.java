package springbasic.cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CafeApplication {
	public static void main(String[] args) {
		SpringApplication.run(CafeApplication.class, args);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(CoffeeConfig.class);
		ctx.refresh();

		AbcCoffeeMachine abcCoffeeMachine = ctx.getBean(AbcCoffeeMachine.class);
		abcCoffeeMachine.brew();
	}
}
