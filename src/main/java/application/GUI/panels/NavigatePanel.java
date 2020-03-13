package application.GUI.panels;

import application.GUI.MainWindow;
import application.Starter;
import application.classes.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NavigatePanel extends JPanel {

    private ArrayList<JRadioButton> buttonList = new ArrayList<JRadioButton>();
    private StringBuilder query = new StringBuilder();
    private String operator = "";
    private int flag = 1;
    boolean series1b = false;
    boolean series2b = false;
    boolean series3b = false;
    boolean series4b = false;
    boolean series5b = false;
    boolean series6b = false;

    public NavigatePanel() {
        JRadioButton buttonAnd = new JRadioButton("И");
        JRadioButton buttonOr = new JRadioButton("Или");


        buttonList.add(buttonAnd);
        buttonList.add(buttonOr);


        final JButton buttonAll = new JButton("Показать все");
        final JButton button1 = new JButton("Удовлетворительные");
        final JButton button2 = new JButton("Хорошие");
        final JButton button3 = new JButton("Отличные");
        final JButton buttonNot1 = new JButton("Не удовлетворительные");
        final JButton buttonNot2 = new JButton("Не хорошие");
        final JButton buttonNot3 = new JButton("Не отличные");
        final JButton buttonReset = new JButton("Сбросить");

        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        buttonNot1.setEnabled(false);
        buttonNot2.setEnabled(false);
        buttonNot3.setEnabled(false);
        buttonReset.setEnabled(false);

        JPanel mainPanel = new JPanel(new GridLayout(2,1));
        JPanel radioPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        final ButtonGroup group = new ButtonGroup();
        group.add(buttonAnd);
        group.add(buttonOr);
        radioPanel.add(buttonAnd);
        radioPanel.add(buttonOr);


        buttonPanel.add(buttonAll);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(buttonNot1);
        buttonPanel.add(buttonNot2);
        buttonPanel.add(buttonNot3);
        buttonPanel.add(buttonReset);


        mainPanel.add(radioPanel);
        mainPanel.add(buttonPanel);
        add(mainPanel);



        buttonAnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                query = new StringBuilder("from Record WHERE ");
                flag = 1;
                getOperator(group.getSelection());
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                buttonNot1.setEnabled(true);
                buttonNot2.setEnabled(true);
                buttonNot3.setEnabled(true);
            }
        });

        buttonOr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                query = new StringBuilder("from Record WHERE ");
                flag = 1;
                getOperator(group.getSelection());
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                buttonNot1.setEnabled(true);
                buttonNot2.setEnabled(true);
                buttonNot3.setEnabled(true);
            }
        });
        buttonAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String condition = "Все";
                query = new StringBuilder("from Record ");
                System.out.println(query);
                query = new StringBuilder();

                MainWindow.panel.remove(MainWindow.diagramPanel);
                MainWindow.diagramPanel = new DiagramPanel(true,true,true,true,true,true);
                MainWindow.panel.add(MainWindow.diagramPanel, BorderLayout.NORTH);
                MainWindow.panel.remove(MainWindow.table);
                MainWindow.table = new Table(String.valueOf("from Record"));
                MainWindow.panel.add(MainWindow.table);
                MainWindow.panel.updateUI();
            }
        });
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String condition = " (rating between 0 and 30) ";

                button1.setEnabled(false);
                MainWindow.panel.remove(MainWindow.diagramPanel);
                series1b = true;
                MainWindow.diagramPanel = new DiagramPanel(series1b,series2b,series3b,series4b,series5b,series6b);
                MainWindow.panel.add(MainWindow.diagramPanel, BorderLayout.NORTH);
                MainWindow.panel.updateUI();
                createQuery(condition);
                buttonReset.setEnabled(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String condition = " (rating between 40 and 70) ";

                button2.setEnabled(false);
                MainWindow.panel.remove(MainWindow.diagramPanel);
                series2b = true;
                MainWindow.diagramPanel = new DiagramPanel(series1b,series2b,series3b,series4b,series5b,series6b);
                MainWindow.panel.add(MainWindow.diagramPanel, BorderLayout.NORTH);
                MainWindow.panel.updateUI();
                createQuery(condition);
                buttonReset.setEnabled(true);
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String condition = " (rating between 80 and 100) ";

                button3.setEnabled(false);
                MainWindow.panel.remove(MainWindow.diagramPanel);
                series3b = true;
                MainWindow.diagramPanel = new DiagramPanel(series1b,series2b,series3b,series4b,series5b,series6b);
                MainWindow.panel.add(MainWindow.diagramPanel, BorderLayout.NORTH);
                MainWindow.panel.updateUI();
                createQuery(condition);
                buttonReset.setEnabled(true);
            }
        });
        buttonNot1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String condition = " (rating between 31 and 100) ";

                buttonNot1.setEnabled(false);
                buttonReset.setEnabled(true);
                MainWindow.panel.remove(MainWindow.diagramPanel);
                series4b = true;
                MainWindow.diagramPanel = new DiagramPanel(series1b,series2b,series3b,series4b,series5b,series6b);
                MainWindow.panel.add(MainWindow.diagramPanel, BorderLayout.NORTH);
                MainWindow.panel.updateUI();
                createQuery(condition);
                createQuery(condition);
            }
        });
        buttonNot2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String condition = " ((rating between 0 and 39)OR(rating between 71 and 100)) ";

                buttonNot2.setEnabled(false);
                buttonReset.setEnabled(true);
                MainWindow.panel.remove(MainWindow.diagramPanel);
                series5b = true;
                MainWindow.diagramPanel = new DiagramPanel(series1b,series2b,series3b,series4b,series5b,series6b);
                MainWindow.panel.add(MainWindow.diagramPanel, BorderLayout.NORTH);
                MainWindow.panel.updateUI();
                createQuery(condition);
                createQuery(condition);
            }
        });
        buttonNot3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String condition = " (rating between 0 and 79) ";

                buttonNot3.setEnabled(false);
                buttonReset.setEnabled(true);
                MainWindow.panel.remove(MainWindow.diagramPanel);
                series6b = true;
                MainWindow.diagramPanel = new DiagramPanel(series1b,series2b,series3b,series4b,series5b,series6b);
                MainWindow.panel.add(MainWindow.diagramPanel, BorderLayout.NORTH);
                MainWindow.panel.updateUI();
                createQuery(condition);
                createQuery(condition);
            }
        });
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                query = new StringBuilder("from Record WHERE");
                flag = 1;
                series1b = false;
                series2b = false;
                series3b = false;
                series4b = false;
                series5b = false;
                series6b = false;
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                buttonNot1.setEnabled(true);
                buttonNot2.setEnabled(true);
                buttonNot3.setEnabled(true);
                MainWindow.panel.remove(MainWindow.diagramPanel);
                MainWindow.diagramPanel = new DiagramPanel(series1b,series2b,series3b,series4b,series5b,series6b);
                MainWindow.panel.add(MainWindow.diagramPanel, BorderLayout.NORTH);
                MainWindow.panel.remove(MainWindow.table);
                MainWindow.table = new Table("from Record where rating = '-1'");
                MainWindow.panel.add(MainWindow.table);
                MainWindow.panel.updateUI();
                buttonReset.setEnabled(false);
            }
        });
    }



    private void getOperator(ButtonModel button){
        for (int i = 0; i < buttonList.size(); i++) {
            if ( buttonList.get(i).getModel().equals(button)){
                if (buttonList.get(i).getText().equals("И")){
                    operator = "AND";
                }
                if (buttonList.get(i).getText().equals("Или")){
                    operator = "OR";
                }
            }
        }
    }

    private void createQuery(String condition){

        if (flag == 0){
            query.append(operator);
        }
        query.append(condition);
        flag = 0;

        MainWindow.panel.remove(MainWindow.table);
        MainWindow.table = new Table(String.valueOf(query));
        MainWindow.panel.add(MainWindow.table);
        MainWindow.panel.updateUI();
    }
}
