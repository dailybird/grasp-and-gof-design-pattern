package gof.simple_factory;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class OrderFactory {

    public static Order createOrder(){

        Object style = new Object();
        Object body = new Object();
        Object appendix = new Object();

        Order order = new Order(style, body, appendix);

        return order;

    }

}
