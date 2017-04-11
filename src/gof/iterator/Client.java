package gof.iterator;

import java.util.Iterator;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client {

    public void doSome(){
        SalaryCollection collection = new SalaryCollection();
        int sum = 0;
        for (; collection.hasNext(); ) {
            Salary salary = collection.next();
            sum += salary.getValue();
        }

    }

}
