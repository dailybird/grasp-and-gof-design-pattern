package gof.abstract_factory;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client {

    public void doSome(){
        FlatChartFactory flatChartFactory = new FlatChartFactory();
        CrystalChartFactory crystalChartFactory = new CrystalChartFactory();

        BarChart barChart = flatChartFactory.createBarChart();
        LineChart lineChart = crystalChartFactory.createLineChart();
    }

}
