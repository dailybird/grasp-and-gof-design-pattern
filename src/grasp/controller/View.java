package grasp.controller;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class View {

    public void send(){
        Controller controller = new Controller();
        Object res = controller.dispatch(null);
    }

}
