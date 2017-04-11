package gof.state;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class DeliveringState implements State {
    @Override
    public void handle(Order order) {
        // 执行发布操作业务代码
        // ...
        // 转换状态
        order.setState(null);
    }
}
