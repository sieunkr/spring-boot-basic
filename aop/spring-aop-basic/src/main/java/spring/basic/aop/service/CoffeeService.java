package spring.basic.aop.service;

import org.springframework.stereotype.Service;
import spring.basic.aop.dto.Coffee;

import java.util.Arrays;
import java.util.Collection;

@Service
public class CoffeeService {

    public Collection<Coffee> listCoffee(){

        Collection<Coffee> coffees = Arrays.asList(new Coffee("라떼", 1200, true), new Coffee("아메리카노", 900, false));
        return coffees;
    }

    public Coffee findCoffee(String name){

        return new Coffee("라떼", 1200, true);
    }


    public void createCoffee(){
        System.out.println("새로운 Coffee 만들기");
    }


    public void deleteCoffee(){
        System.out.println("Coffee 제거");
    }

}
