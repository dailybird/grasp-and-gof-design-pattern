package gof.decorator;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class CoffeeSugerDecorator extends CoffeeDecorator {

    public CoffeeSugerDecorator(Coffee coffee) {
        super(coffee);
    }

    public void addSuger(){

    }

    @Override
    public int getPrice() {
        return this.coffee.getPrice() + 20;
    }
}
