package spring.basic.cafe.web.usecase;

import org.springframework.stereotype.Service;

/**
 * 커피 만드는 일
 *
 * @author Eddy.Kim
 */
@Service
public class CoffeeService {

    public String brew(){
        return "커피를 추출합니다.";
    }

}
