package gof.state;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class Client {

    public void doSome(){
        // 初始化，进入准备状态
        Order order = new Order();
        // 进入完成状态
        order.action();
        // 进入配送状态
        order.action();
        // 结束
    }

}
