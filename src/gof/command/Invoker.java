package gof.command;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Invoker {

    private History history = new History();

    public void invoke(Command command){
        this.history.add(command);
    }

    public void undo(){
        this.history.undo();
    }

}
