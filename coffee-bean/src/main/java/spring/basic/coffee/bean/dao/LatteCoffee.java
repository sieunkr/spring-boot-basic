package spring.basic.coffee.bean.dao;

import org.springframework.stereotype.Component;

@Component
public class LatteCoffee extends Coffee {
    public LatteCoffee(){
        super("라떼", 1300);
    }
}
