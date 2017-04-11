package gof.template_method;

/**
 *
 * Created by dailybird on 17/4/11.
 */
abstract public class PayOrder {

    final public void check(){
        this.confirm();
        this.pay();
        this.getBill();
    }

    // 确认
    private void confirm(){

    }

    // 获得账单
    private void getBill(){

    }

    // 子类中需要实现的方法
    abstract protected void pay();

}
