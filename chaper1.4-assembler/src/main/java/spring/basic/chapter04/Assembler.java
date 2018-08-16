package spring.basic.chapter04;

public class Assembler {

    private CoffeeDao coffeeDao;
    private CoffeeMakerService coffeeMakerService;
    private OrderService orderService;

    public Assembler(){
        coffeeDao = new CoffeeDao();
        coffeeMakerService = new CoffeeMakerService(coffeeDao);
        orderService = new OrderService(coffeeDao);

        //만약 CoffeeDao 클래스를 상속받은 CacheCoffeeDao 를 사용해야 한다면,
        //coffeeDao = new CacheCoffeeDao();
    }

    public CoffeeMakerService getCoffeeMakerService() {
        return coffeeMakerService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
