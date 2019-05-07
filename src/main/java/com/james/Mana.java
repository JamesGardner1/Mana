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

    int phase;
    Battle battle;
    Enemy bandit = new Enemy("Bandit",25,5,10);

    Player player = new Player(this.getName(),1,0,50, 50, 25, 5,10);

    //Battle Interface
    String battleChoice1 = "Attack";
    String battleChoice2 = "Use Item";
    String battleChoice3 = "Run";
    String battleChoice4 = "";

    String attackText = String.format(bandit.getName() +" receives " + player.attack() + " damage.");

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

        awaken();


    }

    public void awaken() {
        phase = 1;
        adventureText.setText("<You awake from your slumber. You try to recall why you are on this stone platform with etched in symbols" +
                ", but you cant remember anything. You then here a mysterious elderly voice.>\nMysterious Voice: You have finally awaken");
        choice1.setText("Who are you?");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void whoAreYou() {
        phase = 2;
        adventureText.setText("Mysterious Voice: That doesnt matter....yet. I just hope the GrandMaster was right about you");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void chest() {
        phase = 3;
        adventureText.setText("Please open the chest.\n <A chest appears in front of you>");
        choice1.setText("Open the chest");
        choice2.setText("(Refuse)'Not until you tell me my I'm here and who you are!'");
        choice3.setText("");
        choice4.setText("");
    }

    public void selectWeapon() {
        phase = 4;
        adventureText.setText("<In the chest you see 3 items: A sword, a bow, and a orb>\n Mysterious Voice: We..Or I should say you don't have all day. Choooosseeee Yoooouuuuurrr Weeeeaaappppooonn!");
        choice1.setText("Pick up the sword");
        choice2.setText("Pick up the bow.");
        choice3.setText("Pick up the orb.");
        choice4.setText("");
    }

    public void standStill() {
        phase = 5;
        adventureText.setText("Ha! Well, looks like we are at a standstill. I'd just open the chest if I were you...");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void selectSword() {
        phase = 6;
        adventureText.setText("Mysterious Voice: Basic, yet effective...");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void selectBow() {
        phase = 7;
        adventureText.setText("Mysterious Voice: I hope you know how to use that!\n <Mysterious Voice Laughs>");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void selectOrb() {
        phase = 8;
        adventureText.setText("Mysterious Voice: Ha! Do you even know what that is?!");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void firstBattle() {
        phase = 9;
        adventureText.setText("Looks like you are going to have to use it!\n");
        choice1.setText(battleChoice1);
        choice2.setText(battleChoice2);
        choice3.setText(battleChoice3);
        choice4.setText(battleChoice4);

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



