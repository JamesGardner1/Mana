package com.james;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mana extends JFrame {
    private JProgressBar expBar;
    private JPanel mainPanel;
    private JButton choice1;
    private JButton choice2;
    private JButton choice3;
    private JButton choice4;
    private JTextPane adventureText;
    Player player = new Player(this.getName(),1,0,50, 50, 25, 5,10);


    Mana() {
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        awaken();


    }

    void awaken() {
        adventureText.setText("<You awake from your slumber. You try to recall why you are on this stone platform with etched in symbols" +
                ", but you cant remember anything. You then here a mysterious elderly voice.> Mysterious Voice: You have finally awaken");
        choice1.setText("Who are you?");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

        choice1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adventureText.setText("Mysterious Voice: That doesnt matter....yet. I just hope the GrandMaster was right about you");
                choice1.setVisible(false);
                choice2.setText(">>>>");
                choice3.setText("");
                choice4.setText("");

                choice2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        choice1.setVisible(true);
                        selectWeapon();
                    }
                });
            }
        });

    }

    void selectWeapon() {
        adventureText.setText("Please open the chest. <A chest appears in front of you");
        choice1.setText("Open the chest");
        choice2.setText("(Refuse)'Not until you tell me my I'm here and who you are!'");
        choice3.setText("");
        choice4.setText("");

        choice1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adventureText.setText("<In the chest you see 3 items: A sword, a bow, and a orb> Mysterious Voice: We..Or I should say you don't have all day. Choooosseeee Yoooouuuuurrr Weeeeaaappppooonn!");
                choice1.setVisible(false);
                choice2.setText("Pick up the the sword.");
                choice3.setText("Pick up the bow.");
                choice4.setText("Pick up the orb.");
            }
        });



    }


}

