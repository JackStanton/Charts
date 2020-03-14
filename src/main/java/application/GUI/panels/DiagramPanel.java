package application.GUI.panels;

import application.classes.ChartUtil;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;

public class DiagramPanel extends JPanel {

    public DiagramPanel(boolean series1b,boolean series2b,boolean series3b,boolean series4b,boolean series5b,boolean series6b) {
        JFreeChart chart = ChartUtil.getChart(series1b,series2b,series3b,series4b,series5b,series6b);
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        ChartPanel panel = new ChartPanel(chart);
        add(panel);
    }
    public DiagramPanel(int rating, int equ) {
        JFreeChart chart = ChartUtil.getEqu(rating,equ);
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        ChartPanel panel = new ChartPanel(chart);
        add(panel);
    }
}
