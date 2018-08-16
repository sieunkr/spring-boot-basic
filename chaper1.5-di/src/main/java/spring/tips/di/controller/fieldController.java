package spring.tips.di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.tips.di.service.CoffeeService;

@RequestMapping("/field")
@RestController
public class fieldController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping
    public String list(){
        return coffeeService.toString();
    }

}
