package springbasic.cafe;

import org.springframework.stereotype.Component;

@Component
public class EthiopiaCapsuleCoffee implements CapsuleCoffee {

    public void brew() {
        System.out.println("에티오피아 커피를 추출합니다.");
    }
}
