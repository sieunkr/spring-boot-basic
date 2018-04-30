package spring.basic.aop.dto;

import lombok.Data;

@Data
public class Coffee {

    private String name;
    private Integer price;
    private Boolean isMilk;


    public Coffee(){

    }

    public Coffee(String name, Integer price, Boolean isMilk){
        this.name = name;
        this.price = price;
        this.isMilk = isMilk;
    }


}
