package gof.flyweight;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client {

    public void doSome(){
        ResourcePool pool = new ResourcePool();

        try {
            Object o = pool.apply(4);
        } catch (Exception e) {
            System.out.println("资源申请失败");
            e.printStackTrace();
        }
    }

}
