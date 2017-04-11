package gof.mediator;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Mediator {

    private Patron patron = new Patron();
    private Deliverer deliverer = new Deliverer();
    private Staff staff = new Staff();

    public void askForDeliverer(){
        this.deliverer.receiveAsk();
    }

    public void askForStaff(){
        this.staff.receiveAsk();
    }

    public void sendConfirm(){
        this.patron.getConfirm();
    }

    public void requestToDeliver(){
        this.deliverer.receiveRequest();
    }
}
