package gof.state;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public interface State {

    void handle(Order order);

}
