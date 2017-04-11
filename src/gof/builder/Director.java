package gof.builder;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Director {

    private OrderBuilder orderBuilder;

    public Director(OrderBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }

    public void build(){
        this.orderBuilder.convertAddr();
        this.orderBuilder.convertFooter();
        this.orderBuilder.convertHeader();
        this.orderBuilder.convertTime();
    }
}
