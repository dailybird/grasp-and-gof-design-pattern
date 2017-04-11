package gof.decorator;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class CoffeeMilkDecorator extends CoffeeDecorator {

    public CoffeeMilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public void addMilk(){

    }

    @Override
    public int getPrice() {
        return this.coffee.getPrice() + 10;
    }
}
