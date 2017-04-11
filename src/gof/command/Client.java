package gof.command;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client {

    public void doSome(){
        Command commandA = new QueryCommand();
        Command commandB = new CreateCommand();
        Command commandC = new UpdateCommand();
        Command commandD = new DeleteCommand();

        Invoker invoker = new Invoker();
        invoker.invoke(commandA);
        invoker.invoke(commandB);
        invoker.undo();
        invoker.invoke(commandC);
        invoker.undo();
        invoker.invoke(commandD);
    }
}
