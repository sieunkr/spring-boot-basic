package com.example.demo.entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstController {
    
    @Autowired
    @Qualifier("firstRequestComponent")
    private RequestComponent requestComponent;

    @GetMapping
    public void test(){

        //requestComponent.getRestTemplate()...
    }
}
