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


        String[] equArr = new String[6];
        equArr[0] = ""+1;
        for (int i = 0; i < equArr.length-1; i++) {
            equArr[i+1] = ""+((i+1)*10);
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
                MainWindow.table = new Table("from Record where rating between "+(rating-(equ/10))+" AND "+(rating+(equ/10)));
                MainWindow.panel.add(MainWindow.table);
                MainWindow.panel.updateUI();
            }
        });
    }
}
