package spring.basic.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.basic.aop.annotation.LogAspect;
import spring.basic.aop.dto.Coffee;
import spring.basic.aop.service.CoffeeService;

import javax.websocket.server.PathParam;
import java.util.Collection;

@RestController
public class HomeController {

    @Autowired
    private CoffeeService coffeeService;


    @GetMapping("/coffees")
    public Collection<Coffee> listCoffee(){

        return coffeeService.listCoffee();
    }

    @GetMapping("/coffees/{name}")
    public Coffee findCoffee(@PathVariable(name = "name") String name){

        return coffeeService.findCoffee(name);
    }


    @PostMapping("/coffees")
    @LogAspect
    public void createCoffee(){

        coffeeService.createCoffee();
    }


    @DeleteMapping("/coffees")
    public void deleteCoffee(){

        coffeeService.deleteCoffee();
    }

}
