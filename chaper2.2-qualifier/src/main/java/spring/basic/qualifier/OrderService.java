package spring.basic.qualifier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class OrderService {

    @Autowired
    //@Qualifier("juiceDao")
    @Qualifier("myDao")
    private CafeDao cafeDao;

    public OrderService(){
    }

    public String order(){
        //return "커피 주문을 합니다.";
        return cafeDao.order("라떼");
    }

}
