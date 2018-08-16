package spring.basic.container;

import java.util.HashMap;

public class CoffeeDao {

    private HashMap<String, Coffee> coffeeHashMap = new HashMap<>();

    public void insert(Coffee coffee){
        coffeeHashMap.put(coffee.getName(), coffee);
    }

    public String order(String name){
        return "CoffeeDao를 사용해서, 커피 주문을 합니다. 가격은 " + coffeeHashMap.get(name).getPrice() + "입니다.";
    }

}
