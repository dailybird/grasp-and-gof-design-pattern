package gof.state;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class Order {

    private State state = new PrepareState();

    public void setState(State state) {
        this.state = state;
    }

    public void action(){
        this.state.handle(this);
    }
}
