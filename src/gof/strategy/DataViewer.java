package gof.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class DataViewer {

    private SortStrategy strategy;

    private List<Object> objects = new ArrayList<Object>();

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void render(){
        this.strategy.ascend(this.objects);
        // or
        this.strategy.descend(this.objects);
        // render view
    }
}
