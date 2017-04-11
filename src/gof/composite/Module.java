package gof.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Module implements Renderable {

    private List<Renderable> components = new ArrayList<>();

    @Override
    public void draw() {
        Iterator<Renderable> iterator = this.components.iterator();
        while (iterator.hasNext()){
            iterator.next().draw();
        }
    }
}
