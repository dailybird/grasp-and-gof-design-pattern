package gof.mediator;

/**
 * Created by dailybird on 17/4/10.
 *
 */
public class Staff {

    private Mediator mediator = new Mediator();

    public void receiveAsk(){

    }

    public void sendRequest(){
        this.mediator.requestToDeliver();
    }

}
