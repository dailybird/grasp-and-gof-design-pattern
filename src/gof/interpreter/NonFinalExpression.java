package gof.interpreter;

/**
 *
 * Created by dailybird on 17/4/10.
 */
abstract public class NonFinalExpression implements Expression {

    protected Expression left;
    protected Expression right;

}
