package com.example.demo.configuration;

import com.example.demo.entrypoints.RequestComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RequestComponentConfig {

    /*

    이런식으로 할 필요 없음

    @Autowired
    @Qualifier("firstRestTemplate")
    private RestTemplate firstRestTemplate;

    @Bean
    public RequestComponent firstRequestComponent(){
        return new RequestComponent(firstRestTemplate);
    }
    */


    @Bean
    public RequestComponent firstRequestComponent(RestTemplate firstRestTemplate){
        return new RequestComponent(firstRestTemplate);
    }

    @Bean
    public RequestComponent secondRequestComponent(RestTemplate secondRestTemplate){
        return new RequestComponent(secondRestTemplate);
    }

}
