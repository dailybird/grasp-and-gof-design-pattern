package gof.state;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class PrepareState implements State {
    @Override
    public void handle(Order order) {
        // 执行加工操作业务代码
        // ...
        // 转换状态
        order.setState(new FinishedState());

    }
}
