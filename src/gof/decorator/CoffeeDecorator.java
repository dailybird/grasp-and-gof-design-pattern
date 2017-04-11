package gof.decorator;

/**
 *
 * Created by dailybird on 17/4/10.
 */
abstract public class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

}
