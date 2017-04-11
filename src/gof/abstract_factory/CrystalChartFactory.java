package gof.abstract_factory;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class CrystalChartFactory extends ChartFactory {
    @Override
    public PieChart createPieChart() {
        return new CrystalPieChart();
    }

    @Override
    public LineChart createLineChart() {
        return new CrystalLineChart();
    }

    @Override
    public BarChart createBarChart() {
        return new CrystalBarChart();
    }
}
