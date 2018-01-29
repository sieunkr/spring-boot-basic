package spring.basic.cafe.web.usecase;

import org.springframework.stereotype.Service;

/**
 * 브런치 만드는 일
 *
 * @author Eddy.Kim
 */
@Service
public class BrunchService {

    public String make(){
        return "브런치를 요리합니다.";
    }
}
