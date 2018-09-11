package com.example.demo.entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class RequestComponent {

    /*
    RestTemplate 가 한개만 있는 경우에는 아래와 같이 사용하면 되지만, RestTemplate가 두개가 있는 경우는 RestTempate를 외부에서 주입해줘야 함
    - RestTemplate Autowired 하는 부분 주석
    - RequestCOmponent 의 @Component 를 제거
    - 용도에 맞게 RequestComponent 빈을 생성해줘야 함 - RequestComponentConfig
    @Autowired
    private RestTemplate restTemplate;
    */

    private final RestTemplate restTemplate;

    @Autowired
    public RequestComponent(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
