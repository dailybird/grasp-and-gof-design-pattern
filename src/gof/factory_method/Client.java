package gof.factory_method;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client {

    public void doSome(){

        OrderFactory factory = new PdfOrderFactory();
        Order order = factory.export();

    }
}
