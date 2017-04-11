package gof.builder;

/**
 *
 * Created by dailybird on 17/4/10.
 */
abstract public class OrderBuilder {

    protected Object res;

    public Object getRes() {
        return res;
    }

    abstract public void convertHeader();
    abstract public void convertAddr();
    abstract public void convertTime();
    abstract public void convertFooter();

}
