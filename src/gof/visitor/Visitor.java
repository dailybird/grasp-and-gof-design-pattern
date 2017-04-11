package gof.visitor;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public interface Visitor {
    void visitOrder(Order order);
    void visitSubOrder(SubOrder subOrder);
}
