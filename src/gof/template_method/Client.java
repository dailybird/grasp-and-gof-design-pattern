package gof.template_method;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class Client {

    public void doSome(){
        PayOrder payOrderA = new PayOrderByCard();
        // or
        PayOrder payOrderB = new PayOrderByCash();
        payOrderA.check();
    }

}
