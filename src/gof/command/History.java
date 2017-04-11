package gof.command;

import java.util.Stack;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class History {

    private Stack<Command> history = new Stack<>();

    public void undo(){
        Command command = history.pop();
        command.undo();
    }

    public void add(Command command){
        command.redo();
        this.history.push(command);
    }

}
