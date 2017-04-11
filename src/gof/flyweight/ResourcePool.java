package gof.flyweight;

import java.util.ArrayList;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class ResourcePool {

    public ArrayList<Object> resources = new ArrayList<>();

    public Object apply(int index) throws Exception {
        if(resources.size() >= index + 1){

            if(resources.get(index) == null){
                Object flyweight = new Object();
                resources.set(index, flyweight);
            }

            return resources.get(index);

        }else{
            throw new Exception("Invalid request");
        }
    }

}
