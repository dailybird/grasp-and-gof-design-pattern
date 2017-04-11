package gof.facade;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client {

    public void callAPI(){
        APICaller apiCaller = new APICaller();
        Object res = apiCaller.call();
    }

}
