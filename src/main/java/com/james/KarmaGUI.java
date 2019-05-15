package com.james;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class KarmaGUI extends JFrame{
    private JTable karmaTable;
    private JPanel karmaPanel;
    private JLabel karmaResult;

    int karmaPoints = 0;

    public void raiseKarma(){
        karmaPoints = karmaPoints + 1;
    }

    public void lowerKarma(){
        karmaPoints = karmaPoints - 1;
    }


    KarmaDB db;

    KarmaGUI(KarmaDB db) {

        this.db = db;

        setContentPane(karmaPanel);
        pack();
        setTitle("Karma Database");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        if (karmaPoints > 1) {karmaResult.setText("GOOD");}
        else if (karmaPoints < -1) {karmaResult.setText("BAD");} else {karmaResult.setText("NEUTRAL");}
    }

    public void configureTable() {
        Vector columnNames = db.getColumnNames();
        Vector data = db.getKarma();

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        karmaTable.setModel(tableModel);
    }
}
