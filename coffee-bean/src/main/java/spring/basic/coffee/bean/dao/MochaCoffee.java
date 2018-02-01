package spring.basic.coffee.bean.dao;

import org.springframework.stereotype.Component;

@Component
public class MochaCoffee extends Coffee {
    public MochaCoffee(){
        super("모카", 1500);
    }
}
