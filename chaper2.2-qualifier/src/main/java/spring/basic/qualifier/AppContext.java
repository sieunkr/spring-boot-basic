package spring.basic.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

    @Bean
    public OrderService orderService(){
        return new OrderService();
    }

    @Bean
    public CafeDao coffeeDao(){
        CoffeeDao coffeeDao = new CoffeeDao();
        coffeeDao.insert(new Coffee("라떼",1200));
        coffeeDao.insert(new Coffee("모카",1400));
        return coffeeDao;
    }

    @Bean
    public CafeDao juiceDao(){
        return new JuiceDao();
    }

    @Bean
    @Qualifier("myDao")
    public CafeDao milkDao(){
        return new MilkDao();
    }



}
