package spring.basic.di.setter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

    @Bean
    public OrderService orderService(){

        //Setter 주입 방식
        OrderService orderService = new OrderService();
        orderService.setCoffeeDao(coffeeDao());
        return orderService;
    }

    @Bean
    public CoffeeDao coffeeDao(){
        CoffeeDao coffeeDao = new CoffeeDao();
        coffeeDao.insert(new Coffee("라떼",1200));
        coffeeDao.insert(new Coffee("모카",1400));
        return coffeeDao;
    }

}
