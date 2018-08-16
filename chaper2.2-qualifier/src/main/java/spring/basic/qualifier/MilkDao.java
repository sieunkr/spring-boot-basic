package spring.basic.qualifier;

public class MilkDao extends CafeDao {

    @Override
    public String order(String name){
        return "밀크 우유를 주문합니다.";
    }
}
