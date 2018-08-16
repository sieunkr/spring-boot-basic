package spring.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

    @Bean
    public OrderService orderService(){
        return new OrderService(coffeeDao());
    }

    @Bean
    public CoffeeDao coffeeDao(){
        CoffeeDao coffeeDao = new CoffeeDao();
        coffeeDao.insert(new Coffee("라떼",1200));
        coffeeDao.insert(new Coffee("모카",1400));
        return coffeeDao;
    }

    /*
    만약 아래와 같이, coffeeDao 를 주입하는 곳이 더 있다면?
    coffeeDao() 메서드는 매번 새로운 객체를 생성하지 않는다.
    스프링 컨테이너가 생성한 Bean은 싱글톤 객체이다!!
    @Bean
    public DeliveryService deliveryService(){
        return new DeliveryService(coffeeDao());
    }
    */
}
