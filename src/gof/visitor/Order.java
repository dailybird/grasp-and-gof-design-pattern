package gof.visitor;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class Order implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitOrder(this);
    }

    public void order(){
        // Order 自身的业务
    }
}
