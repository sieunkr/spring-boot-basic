package spring.basic.qualifier;

public class JuiceDao extends CafeDao {

    @Override
    public String order(String name){
        return "생과일 쥬스를 주문합니다.";
    }
}
