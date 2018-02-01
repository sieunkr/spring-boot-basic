package spring.basic.coffee.bean.service;

import spring.basic.coffee.bean.dao.Coffee;


public class CoffeeService {

    private Coffee coffee;

    public CoffeeService(Coffee coffee){
        this.coffee = coffee;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public String brew(){
        return this.coffee.getName() + "를 마십니다.";
    }
}
