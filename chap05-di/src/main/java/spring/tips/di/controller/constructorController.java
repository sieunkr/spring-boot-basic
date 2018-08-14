package spring.tips.di.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.tips.di.service.CoffeeService;

@RequestMapping("/constructor")
@RestController
public class constructorController {

    private final CoffeeService coffeeService;

    constructorController(CoffeeService coffeeService){
        this.coffeeService = coffeeService;
    }
    
    @GetMapping
    public String list(){
        return coffeeService.toString();
    }

}
