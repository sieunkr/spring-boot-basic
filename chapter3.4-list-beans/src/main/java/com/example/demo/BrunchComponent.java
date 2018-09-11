package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class BrunchComponent implements CafeInterface {

    @Override
    public String getOrder() {
        return "브런치를 주문합니다.";
    }
}
