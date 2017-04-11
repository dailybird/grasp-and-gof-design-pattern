package gof.interpreter;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class SubExpression extends NonFinalExpression {

    @Override
    public int interpret(Context context) {
        int left = this.left.interpret(context);
        int right = this.right.interpret(context);
        return left - right;
    }
}
