package gof.factory_method;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class HTMLOrderFactory extends OrderFactory {
    /**
     * 转换为 HTML 格式
     */
    @Override
    protected void convert() {
        this.order = new HTMLOrder();
    }
}
