package gof.proxy;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class DBOperatorProxy implements DBOperator{

    private DBOperator dbOperator = new DBOperatorImpl();

    @Override
    public Object getData() {
        // 前置操作

        Object res = this.dbOperator.getData();

        // 后置操作

        return res;
    }
}
