package application.GUI.panels;


import application.classes.Record;
import com.google.protobuf.StringValue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table extends JPanel {

    public Table(String query) {

        List recordList = Collections.singletonList(0);
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Record.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            recordList = session.createQuery(query).list();
            session.getTransaction().commit();

        }catch (Exception exc){
            exc.printStackTrace();
        }finally {
            sessionFactory.close();
        }

        String[][] data = new String[recordList.size()][];
        ArrayList<Record> list = (ArrayList) recordList;
        for (int i = 0; i < list.size(); i++) {
            data[i] = list.get(i).toStringArray();
        }


                String column[]={"ID","FilmName","Prod","Company","Year","Rating"};
                final JTable jt=new JTable(data,column);
                jt.setCellSelectionEnabled(true);
                ListSelectionModel select= jt.getSelectionModel();
                select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                select.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        String Data = null;
                        int[] row = jt.getSelectedRows();
                        int[] columns = jt.getSelectedColumns();
                        for (int i = 0; i < row.length; i++) {
                            for (int j = 0; j < columns.length; j++) {
                                Data = (String) jt.getValueAt(row[i], columns[j]);
                            } }
                        System.out.println("Table element selected is: " + Data);
                    }
                });
                JScrollPane sp=new JScrollPane(jt);
                add(sp);
    }

}