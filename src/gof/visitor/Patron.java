package gof.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class Patron {

    private List<Order> orders = new ArrayList<>();

    private Visitor visitor;

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public void check(){
        Iterator<Order> iterator = this.orders.iterator();
        while (iterator.hasNext()){
            Order order = iterator.next();
            order.accept(this.visitor);
        }
    }

}
