package gof.mediator;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Patron {

    private Mediator mediator = new Mediator();

    public void getConfirm(){

    }

    public void askProgressToStaff(){
        this.mediator.askForStaff();
    }

    public void askProgressToDeliverer(){
        this.mediator.askForDeliverer();
    }

}
