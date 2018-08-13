package spring.basic.chapter02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter02Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Chapter02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CoffeeMakerService coffeeMakerService = new CoffeeMakerService();
		//coffeeMakerService.method();
		//의존하는 CoffeeDao의 객체도 함께 생성
		//좋은 방법 아니다.
	}
}
