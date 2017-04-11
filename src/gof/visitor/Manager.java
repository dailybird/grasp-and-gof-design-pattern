package gof.visitor;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class Manager {

    public void doSome(){
        Patron patron = new Patron();
        Visitor visitorA = new VisitorImplA();
        // or
        Visitor visitorB = new VisitorImplB();

        patron.setVisitor(visitorA);
        patron.check();
    }

}
