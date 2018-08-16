package spring.tips.di.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.tips.di.service.CoffeeService;

@RestController
@RequestMapping("/lombok")
@RequiredArgsConstructor
public class lombokController {

    private final CoffeeService coffeeService;

    @GetMapping
    public String list(){
        return coffeeService.toString();
    }
}
