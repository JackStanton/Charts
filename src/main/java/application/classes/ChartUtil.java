package application.classes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class ChartUtil{

    public static JFreeChart getChart(boolean series1b,boolean series2b,boolean series3b,boolean series4b,boolean series5b,boolean series6b) {
        XYSeries series1 = new XYSeries("Удовлетворительный");
        for(float i = 0; i < 100; i+=0.1){
            if(i<=30){
                series1.add(i, 1);
            }
            if(30<i && i<70){
                series1.add(i, (70-i)/40);
            }
            if(i>70){
                series1.add(i, 0.002);
            }
        }

        XYSeries series4 = new XYSeries("Не удовлетворительный");
        for(float i = 0; i < 100; i+=0.1){
            if(i<=30){
                series4.add(i, 0.002);
            }
            if(30<i && i<70){
                series4.add(i, 1-(70-i)/40);
            }
            if(i>70){
                series4.add(i, 1);
            }
        }

        XYSeries series2 = new XYSeries("Хороший");
        for(float x = 0; x < 100; x+=0.1){
            if(x<=10){
                series2.add(x, 0.002);
            }
            if(10<x&&x<=40){
                series2.add(x, (x-10)/30);
            }
            if(40<=x&&x<70){
                series2.add(x, 1);
            }
            if(70<=x&&x<90){
                series2.add(x, (90-x)/20);
            }
            if(x>=90){
                series2.add(x, 0.002);
            }
        }

        XYSeries series5 = new XYSeries("Не хороший");
        for(float x = 0; x < 100; x+=0.1){
            if(x<=10){
                series5.add(x, 1);
            }
            if(10<x&&x<=40){
                series5.add(x, 1-(x-10)/30);
            }
            if(40<=x&&x<70){
                series5.add(x, 0.002);
            }
            if(70<=x&&x<90){
                series5.add(x, 1-(90-x)/20);
            }
            if(x>=90){
                series5.add(x, 1);
            }
        }

        XYSeries series3 = new XYSeries("Отличный");
        for(float x = 0; x < 100; x+=0.1){
            if(x>80){
                series3.add(x, 1);
            }
            if(40<x&&x<=80){
                series3.add(x, (x-40)/40);
            }
            if(x<=40){
                series3.add(x, 0.002);
            }
        }

        XYSeries series6 = new XYSeries("Не отличный");
        for(float x = 0; x < 100; x+=0.1){
            if(x>80){
                series6.add(x, 0.002);
            }
            if(40<x&&x<=80){
                series6.add(x, 1-(x-40)/40);
            }
            if(x<=40){
                series6.add(x, 1);
            }
        }

        XYSeries series0 = new XYSeries("Линия принадлежности");

        for(float i = 0; i < 100; i+=0.1){
            series0.add(i, 0.8);
        }


        XYSeriesCollection xyDataset = new XYSeriesCollection();
        xyDataset.addSeries(series0);
        if(series1b){
            xyDataset.addSeries(series1);
        }
        if(series2b){
            xyDataset.addSeries(series2);
        }
        if(series3b){
            xyDataset.addSeries(series3);
        }
        if(series4b){
            xyDataset.addSeries(series4);
        }
        if(series5b){
            xyDataset.addSeries(series5);
        }
        if(series6b){
            xyDataset.addSeries(series6);
        }

        JFreeChart chart = ChartFactory
                .createXYLineChart("График", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        chart.setBackgroundPaint(Color.lightGray);

        setSeriesColorAndWidth(chart,0,Color.gray, new BasicStroke( 2f ));
        setSeriesColorAndWidth(chart,1,Color.red, new BasicStroke( 2f ));
        setSeriesColorAndWidth(chart,2,Color.blue, new BasicStroke( 2f ));
        setSeriesColorAndWidth(chart,3,Color.magenta, new BasicStroke( 2f ));
        return chart;
    }

    private static void setSeriesColorAndWidth(JFreeChart chart, int seriesIndex, Color color,BasicStroke basicStroke) {
        XYPlot xyPlot = chart.getXYPlot();
        XYItemRenderer xyir = xyPlot.getRenderer();
        xyir.setSeriesStroke(seriesIndex, basicStroke);
        xyir.setSeriesPaint(seriesIndex, color);
    }

}