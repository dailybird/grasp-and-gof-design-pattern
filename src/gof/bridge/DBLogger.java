package gof.bridge;

/**
 *
 * Created by dailybird on 17/4/10.
 */
abstract public class DBLogger {
    protected DBOperator operator;

    public void setOperator(DBOperator operator) {
        this.operator = operator;
    }

    abstract void log();
}
