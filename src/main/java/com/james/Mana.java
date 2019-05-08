package com.james;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mana extends JFrame {
    JProgressBar expBar;
    JPanel mainPanel;
    JButton choice1;
    JButton choice2;
    JButton choice3;
    JButton choice4;
    JTextPane adventureText;
    JLabel playerHpLabel;
    JLabel levelLabel;
    JLabel expLabel;
    JLabel manaLabel;




    public Mana(Game.ChoiceHandler choiceHandler) {
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);




        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);

        choice1.setActionCommand("c1");
        choice2.setActionCommand("c2");
        choice3.setActionCommand("c3");
        choice4.setActionCommand("c4");


    }


}


