package gof.factory_method;

/**
 *
 * Created by dailybird on 17/4/10.
 */
abstract public class OrderFactory {

    protected Order order;

    public Order export(){
        this.convert();
        return this.order;
    }

    abstract protected void convert();

}
