package gof.proxy;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client {

    public void doSome(){
        DBOperator operator = new DBOperatorProxy();
        Object o = operator.getData();
    }

}
