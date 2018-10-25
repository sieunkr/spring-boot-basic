package com.example.demo;

public class CafeProvider implements Cafe {

    @Override
    public String order() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "커피를 주문합니다.";
    }
}
