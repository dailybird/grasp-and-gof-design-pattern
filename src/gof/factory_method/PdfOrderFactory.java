package gof.factory_method;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class PdfOrderFactory extends OrderFactory {
    /**
     * 转换为 pdf 格式
     */
    @Override
    protected void convert() {
        this.order = new PdfOrder();
    }
}
