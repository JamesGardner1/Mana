package com.james;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class KarmaGUI extends JFrame{
    private JTable karmaTable;
    private JPanel karmaPanel;

    KarmaDB db;

    KarmaGUI(KarmaDB db) {

        this.db = db;

        setContentPane(karmaPanel);
        pack();
        setTitle("Karma Database");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        configureTable();
        setVisible(false);
    }

    private void configureTable() {

        Vector columnNames = db.getColumnNames();
        Vector data = db.getKarma();

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        karmaTable.setModel(tableModel);
    }
}
