package gof.mediator;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Deliverer {

    private Mediator mediator = new Mediator();

    public void receiveAsk(){

    }

    public void sendConfirm(){
        this.mediator.sendConfirm();
    }

    public void receiveRequest(){

    }

}
