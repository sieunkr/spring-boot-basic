package com.example.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cafe implements InitializingBean, DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("distroy");
    }

    public void order() {
        System.out.println("커피를 주문한다.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
