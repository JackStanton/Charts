package application.GUI;

import application.GUI.panels.DiagramPanel;
import application.GUI.panels.NavigatePanel;
import application.GUI.panels.Table;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 700;
    private static final int WINDOW_WIDTH = 1100;
    private static final int WINDOW_POSITION_X = 220;
    private static final int WINDOW_POSITION_Y = 100;
    public static String title = "Title";
    public static JPanel table;

    public static DiagramPanel diagramPanel = new DiagramPanel(false,false,false,false,false,false);
    public static JPanel panel = new JPanel(new GridLayout(5,1));
    static public JScrollPane scrollPane;

    public MainWindow() throws HeadlessException {

        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(WINDOW_POSITION_X,WINDOW_POSITION_Y);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle(title);
        NavigatePanel navigatePanel = new NavigatePanel();
        panel.add(diagramPanel, BorderLayout.NORTH);

        table = new Table("from Record where rating = '-1'");

        panel.add(table);

        scrollPane = new JScrollPane(panel);
        scrollPane.getVerticalScrollBar().setValue(1);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);
        add(navigatePanel, BorderLayout.SOUTH);





        setVisible(true);
    }
}
