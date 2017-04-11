package gof.state;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class FinishedState implements State {
    @Override
    public void handle(Order order) {
        // 执行通知操作业务代码
        // ...
        // 转换状态
        order.setState(new DeliveringState());
    }
}
