package gof.abstract_factory;

/**
 *
 * Created by dailybird on 17/4/10.
 */
abstract public class ChartFactory {
    abstract public PieChart createPieChart();
    abstract public LineChart createLineChart();
    abstract public BarChart createBarChart();
}
