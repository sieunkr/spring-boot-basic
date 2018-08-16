package spring.basic.autowired;


import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {

    @Autowired
    private CoffeeDao coffeeDao;

    public OrderService(){
    }

    public String order(){
        //return "커피 주문을 합니다.";
        return coffeeDao.order("라떼");
    }

}
