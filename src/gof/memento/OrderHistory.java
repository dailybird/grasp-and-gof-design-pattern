package gof.memento;

import java.util.ArrayList;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class OrderHistory {

    private ArrayList<Memento> mementos = new ArrayList<>();

    public void store(Order order){
        Memento memento = order.createMemento();
        this.mementos.add(memento);
    }

    public void restore(Order order, int index){
        Memento memento = this.mementos.get(index);
        order.restore(memento);
    }

}
