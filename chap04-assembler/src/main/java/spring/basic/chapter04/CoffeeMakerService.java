package spring.basic.chapter04;

public class CoffeeMakerService {

    private CoffeeDao coffeeDao;

    //DI(의존 주입)는 의존하는 객체를 직접 생성하는 대신 의존 객체를 전달 받는 방식
    //생성자를 통해서 의존 객체를 전달받는다.
    public CoffeeMakerService(CoffeeDao coffeeDao){
        this.coffeeDao = coffeeDao;
    }

    /*
    생략
     */
}
