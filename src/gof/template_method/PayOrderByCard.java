package gof.template_method;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class PayOrderByCard extends PayOrder{
    @Override
    protected void pay() {
        // 银行卡支付
    }
}
