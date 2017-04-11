package gof.memento;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Order {

    private State state;

    public Memento createMemento(){
        Memento memento = new Memento();
        memento.setState(this.state);
        return memento;
    }

    public void restore(Memento memento){
        this.state = memento.getState();
    }

}
