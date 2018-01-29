package spring.basic.cafe.web.usecase;

import org.springframework.stereotype.Service;

/**
 * 과일주스 만드는 일
 *
 * @author Eddy.Kim
 */
@Service
public class JuiceService {

    public String grind(){
        return "생과일 주스를 만듭니다.";
    }
}
