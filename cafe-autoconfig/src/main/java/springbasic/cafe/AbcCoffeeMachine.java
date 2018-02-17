package springbasic.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbcCoffeeMachine implements CoffeeMachine {

    @Autowired
    private CapsuleCoffee capsuleCoffee;

    public AbcCoffeeMachine(){
        //this.capsuleCoffee = capsuleCoffee;
    }

    public void brew() {
        capsuleCoffee.brew();
    }
}
