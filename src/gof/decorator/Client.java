package gof.decorator;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client {

    public void offer(){
        Coffee coffee = new SimpleCoffee();

        // 加糖
        Coffee coffeWithSuger = new CoffeeSugerDecorator(coffee);

        // 加牛奶
        Coffee coffeeWithMilkAndSuger = new CoffeeMilkDecorator(coffeWithSuger);

    }

}
