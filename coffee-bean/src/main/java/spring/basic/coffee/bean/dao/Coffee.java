package spring.basic.coffee.bean.dao;

public abstract class Coffee {
    String name;
    Integer price;

    public Coffee(String name, Integer price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
