package spring.basic.chapter02;

public class CoffeeMakerService {

    //의존 객체를 직접 생성
    private CoffeeDao coffeeDao = new CoffeeDao();

    /*
    [좋지 않은 방법]
    CoffeeDao 를 CacheCoffeeDao 로 변경하기 위해서는, 모든 클래스를 찾아서 변경해줘야 한다.
    private CoffeeDao coffeeDao = new CacheCoffeeDao();
     */


    /*
    생략
     */
}
