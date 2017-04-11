package gof.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class Publisher {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void publish(Message message){
        Iterator<Observer> iterator = this.observers.iterator();
        while (iterator.hasNext()){
            Observer observer = iterator.next();
            observer.update(message);
        }
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

}

