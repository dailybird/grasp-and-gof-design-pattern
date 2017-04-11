package gof.iterator;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class SalaryCollection implements Iterator<Salary>{

    private Salary salaries[] = {
            new Salary(10000),
            new Salary(20000),
            new Salary(15000),
            new Salary(30000),
            new Salary(5000),
            new Salary(80000),
            new Salary(9000)
    };

    private Integer index = 0;

    @Override
    public boolean hasNext() {
        return index >= salaries.length;
    }

    @Override
    public Salary next() {
        return salaries[index++];
    }

}
