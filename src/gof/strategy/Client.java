package gof.strategy;

/**
 *
 * Created by dailybird on 17/4/11.
 */
public class Client {

    public void doSome(){
        DataViewer dataViewer = new DataViewer();
        SortStrategy strategyA = new SortByNameStrategy();
        SortStrategy strategyB = new SortByAgeStrategy();
        SortStrategy strategyC = new SortBySalaryStrategy();
        dataViewer.setStrategy(strategyA);
        // or
        dataViewer.setStrategy(strategyB);
        // or
        dataViewer.setStrategy(strategyC);

        dataViewer.render();
    }

}
