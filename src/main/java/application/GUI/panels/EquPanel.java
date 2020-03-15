package application.GUI.panels;

import application.GUI.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquPanel extends JPanel {
    public EquPanel() {
        final JButton buttonEqu = new JButton("Сделать выборку");
        String[] ratingArr = new String[101];
        for (int i = 0; i < 101; i++) {
            ratingArr[i] = ""+i;
        }
        JComboBox comboBox = new JComboBox(ratingArr);


        String[] equArr = new String[5];
        for (int i = 0; i < equArr.length; i++) {
            equArr[i] = ""+(i+1);
        }
        JComboBox equComboBox = new JComboBox(equArr);

        add(new JLabel("Точность: "));
        add(equComboBox);
        add(new JLabel("Рейтинг: "));
        add(comboBox);
        add(buttonEqu);

        buttonEqu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = equComboBox.getSelectedIndex();
                int equ = Integer.parseInt(equArr[index]);
                index = comboBox.getSelectedIndex();
                int rating = Integer.parseInt(ratingArr[index]);
                MainWindow.panel.remove(MainWindow.diagramPanel);
                MainWindow.diagramPanel = new DiagramPanel(rating,equ);
                MainWindow.panel.add(MainWindow.diagramPanel, BorderLayout.NORTH);
                MainWindow.panel.remove(MainWindow.table);
                boolean minResNotExist = true;
                boolean maxResNotExist = false;
                double min = 0;
                double max = 100;
                for (float x = 0; x < 101; x += 0.1) {
                    double y = (1.0 - ((x - rating) * (x - rating) / (equ * equ)));
                    if (minResNotExist) {
                        if (y > 0.8) {
                            min = x;
                            minResNotExist = false;
                            maxResNotExist = true;
                        }

                    }
                    if (maxResNotExist) {
                        if (y < 0.8) {
                            max = x;
                            maxResNotExist = false;
                        }
                    }
                }
                MainWindow.table = new Table("from Record where rating between " + min + " AND " + max);
                MainWindow.panel.add(MainWindow.table);
                MainWindow.panel.updateUI();
            }
        });
    }
}
