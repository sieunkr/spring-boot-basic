package spring.basic.cafe.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.basic.cafe.web.usecase.CoffeeService;

/**
 * 커피 만드는 일에 대한 요청 처리
 *
 * @author Eddy.Kim
 */
@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService service;

    @GetMapping("/brew")
    public String brew(){
        return service.brew();
    }
}
