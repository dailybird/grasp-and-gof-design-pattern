package grasp.controller;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Controller {

    public Object dispatch(Object request){
        Model model = new Model();
        Object res = model.handle(request);
        return res;
    }

}
