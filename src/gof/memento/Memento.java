package gof.memento;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Memento {

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
