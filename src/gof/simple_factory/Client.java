package gof.simple_factory;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client extends OrderFactory {

    public void doSome(){
        Order order = OrderFactory.createOrder();
    }
}
