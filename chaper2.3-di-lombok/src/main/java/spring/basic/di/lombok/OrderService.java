package spring.basic.di.lombok;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {

    private final CoffeeDao coffeeDao;

    /*
    public OrderService(CoffeeDao coffeeDao) {
        this.coffeeDao = coffeeDao;
    }
    */

    public String order(){
        //return "커피 주문을 합니다.";
        return coffeeDao.order("라떼");
    }

}
