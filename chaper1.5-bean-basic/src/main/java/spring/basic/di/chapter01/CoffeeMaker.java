package spring.basic.di.chapter01;

public class CoffeeMaker {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void blew(String coffee){
        System.out.println(name + "에서 " + coffee + "를 추출합니다.");
    }

}
