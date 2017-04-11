package gof.builder;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client {

    private void doSome(){

        OrderBuilder orderBuilder = new OrderJSONBuilder();
        Director director = new Director(orderBuilder);

        // 采用指导器用统一的过程指导构建
        director.build();

        // 从具体的构造类的获得构造结果
        Object res = orderBuilder.getRes();

    }

}
