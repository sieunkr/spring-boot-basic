package spring.basic.coffee.bean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.basic.coffee.bean.service.CoffeeService;

/**
 * 커피 만드는 일에 대한 요청 처리
 *
 * @author Eddy.Kim
 */
@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService mochaCoffeeService;

    @Autowired
    private CoffeeService latteCoffeeService;

    @GetMapping("/mocha")
    public String brewMocha(){
        return mochaCoffeeService.brew();
    }

    @GetMapping("/latte")
    public String brewLatte(){
        return latteCoffeeService.brew();
    }
}
