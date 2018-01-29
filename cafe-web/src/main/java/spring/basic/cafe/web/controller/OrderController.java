package spring.basic.cafe.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 주문에 대한 요청 처리
 *
 * @author Eddy.Kim
 */
@Controller
public class OrderController {

    @RequestMapping(value = "/order", method = { RequestMethod.POST, RequestMethod.GET })
    public String order(Model model, @RequestParam(value="name", required=true, defaultValue="Coffee") String name) {
        model.addAttribute("name", name);
        return "order";
    }

}
