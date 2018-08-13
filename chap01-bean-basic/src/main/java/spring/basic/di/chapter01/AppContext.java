package spring.basic.di.chapter01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

    @Bean
    public CoffeeMaker coffeeMaker(){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.setName("워터드립 커피머신");
        return coffeeMaker;
    }

}
