package springbasic.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbcCoffeeMachine implements CoffeeMachine {

    private CapsuleCoffee capsuleCoffee;

    @Autowired()
    public AbcCoffeeMachine(CapsuleCoffee capsuleCoffee){
        this.capsuleCoffee = capsuleCoffee;
    }

    public void brew() {
        capsuleCoffee.brew();
    }
}
