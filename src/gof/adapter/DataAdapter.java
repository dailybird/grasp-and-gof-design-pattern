package gof.adapter;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class DataAdapter implements DList {
    private Data data;

    public DataAdapter(Data data) {
        this.data = data;
        // 一些转换操作
    }

}
