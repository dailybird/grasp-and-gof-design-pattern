package gof.decorator;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class SimpleCoffee implements Coffee {

    protected int price = 10;

    @Override
    public int getPrice() {
        return this.price;
    }
}
