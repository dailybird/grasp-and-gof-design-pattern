package gof.adapter;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Controller {

    public void dispatch(){
        Viewer viewer = new Viewer();
        Data originData = new Data();
        DList data = new DataAdapter(originData);
        // 要求传入的 DList 类型的对象，我们借助适配器进行了接口适配
        viewer.render(data);
    }

}
