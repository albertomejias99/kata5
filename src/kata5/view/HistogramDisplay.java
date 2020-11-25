package kata5.view;

import javax.swing.JPanel;
import kata5.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    Histogram <String> histogram;

    public HistogramDisplay(String title, Histogram histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart freeChart = ChartFactory.createBarChart("JFreeChart Histogram Display",
                "email domains","nº emails",dataSet,
                PlotOrientation.VERTICAL, false, false,
                rootPaneCheckingEnabled);
        return freeChart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (String key: histogram.keySet()){
            dataSet.addValue(histogram.get(key), "", key);
        }
        return dataSet;
    }
    
    public void execute(){
        this.setVisible(true);
    }
}
