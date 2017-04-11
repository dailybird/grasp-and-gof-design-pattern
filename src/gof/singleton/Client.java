package gof.singleton;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client extends Config {
    public void doSome(){

        Config config = Config.getConfig();

    }
}
