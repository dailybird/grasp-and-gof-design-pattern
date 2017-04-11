package gof.chainofresponsibility;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client {

    public void auth(){

        Object object = new Object();
        Validator validator = new LoginValidator();
        validator.validate(object);

    }

}
