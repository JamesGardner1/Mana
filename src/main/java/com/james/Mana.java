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

    int phase;
    Battle battle;
    Enemy bandit = new Enemy("Bandit",25,5,10);

//    Player player = new Player(this.getName(),1,0,50, 50, 25, 5,10);

    //Battle Interface
    String battleChoice1 = "Attack";
    String battleChoice2 = "Use Item";
    String battleChoice3 = "Run";
    String battleChoice4 = "";

//    String attackText = String.format(bandit.getName() +" receives " + player.attack() + " damage.");

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


//        awaken();

    }




//    public class ChoiceHandler implements ActionListener {
//        public void actionPerformed(ActionEvent event){
//
//            String yourChoice = event.getActionCommand();
//
//
//            switch(phase){
//                case 1:
//                    switch(yourChoice){
//                        case "c1": whoAreYou(); break;
//                    }
//                    break;
//                case 2:
//                    switch(yourChoice) {
//                        case "c1": chest(); break;
//                    }
//                    break;
//                case 3:
//                    switch (yourChoice) {
//                        case "c1": selectWeapon();break;
//                        case "c2": standStill();break;
//                    }
//                    break;
//                case 4:
//                    switch (yourChoice) {
//                        case "c1": selectSword();break;
//                        case "c2": selectBow();break;
//                        case "c3": selectOrb();break;
//                    }
//                    break;
//                case 5:
//                    switch (yourChoice) {
//                        case "c1":chest();break;
//                    }
//                    break;
//                case 6:
//                    switch (yourChoice) {
//                        case "c1":firstBattle();break;
//                    }
//                    break;
//                case 7:
//                    switch (yourChoice) {
//                        case "c1":firstBattle();break;
//                    }
//                    break;
//                case 8:
//                    switch (yourChoice){
//                        case "c1":firstBattle();break;
//                    }
//                    break;
//                case 9:
//                    switch (yourChoice){
//                        case "c1":break;
//                        case "c2":break;
//
//                    }
//                    break;
//                case 10:
//                    switch (yourChoice){
//                        case "c1":firstBattle();
//                    }
//
//            }
//
//        }
//    }










}
//
//



