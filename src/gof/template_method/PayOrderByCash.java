package gof.template_method;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class PayOrderByCash extends PayOrder {
    @Override
    protected void pay() {
        // 现金支付
    }
}
