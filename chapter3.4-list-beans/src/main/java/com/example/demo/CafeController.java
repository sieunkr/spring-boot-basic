package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cafe")
public class CafeController {

    @Autowired
    private List<CafeInterface> cafeInterfaceList;

    //Bean 이름이 Key
    @Autowired
    private Map<String, CafeInterface> cafeInterfaceMap;

    @Autowired
    private ApplicationContext applicationContext;


    @GetMapping
    public void getList(){

        cafeInterfaceList.forEach(cafeInterface -> System.out.println(cafeInterface.getOrder()));
        //cafeInterfaceMap.entrySet().forEach(c -> System.out.println("빈이름-" + c.getKey() + " " + c.getValue().getOrder()));
        cafeInterfaceMap.forEach((key, value) -> System.out.println("빈이름-" + key + " " + value.getOrder()));

        //applicationContext 를 활용해서도 가져올수 있기는 하다..
        System.out.println(applicationContext.getBeansOfType(CafeInterface.class).size());

    }
}
