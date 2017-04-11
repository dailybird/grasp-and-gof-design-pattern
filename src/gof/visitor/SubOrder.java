package gof.visitor;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class SubOrder implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitSubOrder(this);
    }

    public void subOrder(){
        // SubOrder 自身的业务
    }

}
