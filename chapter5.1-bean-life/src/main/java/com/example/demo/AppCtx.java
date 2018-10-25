package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean
    public Cafe cafe(){
        Cafe cafe = new Cafe();
        return cafe;
    }
}
