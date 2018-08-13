package spring.basic.chap03;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chap03Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Chap03Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CoffeeDao coffeeDao = new CoffeeDao();
		CoffeeMakerService coffeeMakerService01 = new CoffeeMakerService(coffeeDao);
		//의존 객체를 생성자를 통해 주입한다.

		CoffeeDao cacheCoffeeDao = new CacheCoffeeDao();
		CoffeeMakerService coffeeMakerService02 = new CoffeeMakerService(cacheCoffeeDao);

	}
}
