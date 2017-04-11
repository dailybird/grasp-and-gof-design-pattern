package gof.interpreter;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client {

    public int calulate(){
        Context context = new Context();

        Expression expression = new SubExpression();
        int res = expression.interpret(context);

        return res;
    }

}
