package springbasic.cafe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoffeeConfig {

    @Bean
    public CapsuleCoffee capsuleCoffee() {
        return new EthiopiaCapsuleCoffee();
    }

    @Bean
    public AbcCoffeeMachine abcCoffeeMachine() {
        return new AbcCoffeeMachine(capsuleCoffee());
    }

}
