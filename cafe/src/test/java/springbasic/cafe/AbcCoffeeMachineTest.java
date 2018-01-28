package springbasic.cafe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CoffeeConfig.class)
public class AbcCoffeeMachineTest {

    @Autowired
    private AbcCoffeeMachine coffeeMachine;


    @Test
    public void brew() {
        coffeeMachine.brew();
    }

}
