package gof.strategy;

import java.util.List;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public interface SortStrategy {

    void ascend(List<Object> objects);
    void descend(List<Object> objects);

}
