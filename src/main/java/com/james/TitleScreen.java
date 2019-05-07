package com.james;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen extends JFrame {
    private JButton startButton;
    private JPanel titlePanel;
    private JLabel headerLabel;

    public TitleScreen(Game.ChoiceHandler choiceHandler) {
        setContentPane(titlePanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        startButton.addActionListener(choiceHandler);
        startButton.setActionCommand("start");
    }

}
