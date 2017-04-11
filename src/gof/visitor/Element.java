package gof.visitor;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public interface Element {
    void accept(Visitor visitor);
}
