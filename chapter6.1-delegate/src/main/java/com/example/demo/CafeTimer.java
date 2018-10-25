package com.example.demo;

public class CafeTimer implements Cafe {

    private final Cafe delegate;

    public CafeTimer(Cafe cafe){
        this.delegate = cafe;
    }

    @Override
    public String order() {

        long start = System.nanoTime();
        String result = delegate.order();
        long end = System.nanoTime();

        System.out.println("수행시간 : " + (end - start));

        return result;
    }
}
