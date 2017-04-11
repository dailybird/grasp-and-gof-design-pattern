package gof.abstract_factory;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class FlatChartFactory extends ChartFactory {
    @Override
    public PieChart createPieChart() {
        return new FlatPieChart();
    }

    @Override
    public LineChart createLineChart() {
        return new FlatLineChart();
    }

    @Override
    public BarChart createBarChart() {
        return new FlatBarChart();
    }
}
