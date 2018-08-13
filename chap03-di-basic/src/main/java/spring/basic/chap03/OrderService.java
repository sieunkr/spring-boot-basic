package spring.basic.chap03;

public class OrderService {
    private CoffeeDao coffeeDao;

    //DI(의존 주입)는 의존하는 객체를 직접 생성하는 대신 의존 객체를 전달 받는 방식
    //생성자를 통해서 의존 객체를 전달받는다.
    public OrderService(CoffeeDao coffeeDao){
        this.coffeeDao = coffeeDao;
    }
}
