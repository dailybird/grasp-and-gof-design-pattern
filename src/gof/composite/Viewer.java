package gof.composite;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Viewer {

    public void render(){
        Renderable page = new Module();
        page.draw();
    }

}
