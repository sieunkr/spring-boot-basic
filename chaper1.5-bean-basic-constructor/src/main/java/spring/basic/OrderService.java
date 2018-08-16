package spring.basic;


public class OrderService {

    private CoffeeDao coffeeDao;

    public OrderService(CoffeeDao coffeeDao){
        this.coffeeDao = coffeeDao;
    }

    public String order(){
        //return "커피 주문을 합니다.";
        return coffeeDao.order("라떼");
    }

}
