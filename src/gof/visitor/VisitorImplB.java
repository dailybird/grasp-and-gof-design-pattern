package gof.visitor;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class VisitorImplB implements Visitor{
    @Override
    public void visitOrder(Order order) {
        order.order();
    }

    @Override
    public void visitSubOrder(SubOrder subOrder) {
        subOrder.subOrder();
    }
}
