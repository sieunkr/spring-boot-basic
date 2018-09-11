package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class CoffeeComponent implements CafeInterface {

    @Override
    public String getOrder() {
        return "커피를 주문합니다.";
    }
}
