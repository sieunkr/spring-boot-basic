package spring.basic.chapter04;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter04Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Chapter04Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Assembler assembler = new Assembler();
		CoffeeMakerService coffeeMakerService = assembler.getCoffeeMakerService();
		OrderService orderService = assembler.getOrderService();
		//Assembleer는 자신이 생성하고 조립한 객체를 리턴하는 메서드를 제공한다.
	}
}
