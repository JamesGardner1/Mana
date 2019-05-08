package com.james;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    //Learned this from How to make a Text Adventure Game with GUI in Java P3 - Adding a function to button
    ChoiceHandler choiceHandler = new ChoiceHandler();
    Player player = new Player();
    Mana mana = new Mana(choiceHandler);
    TitleScreen titleScreen = new TitleScreen(choiceHandler);
    VisiblityManager visiblityManager = new VisiblityManager(mana, titleScreen);
    Sequence sequence = new Sequence(this, mana, titleScreen, visiblityManager);

    String nextChoice1, nextChoice2, nextChoice3, nextChoice4;

    public static void main(String[] args) {

      new Game();


	// write your code here
    }

    public Game(){

        visiblityManager.showTitleScreen();
        sequence.defaultStats();
        sequence.setUIDefault();


    }

    public class ChoiceHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String yourChoice = e.getActionCommand();

            switch(yourChoice){
                case "start": visiblityManager.startGame();sequence.awaken(); break;
                case "c1": sequence.selectChoice(nextChoice1); break;
                case "c2": sequence.selectChoice(nextChoice2);break;
                case "c3": sequence.selectChoice(nextChoice3);break;
                case "c4": sequence.selectChoice(nextChoice4);break;
            }

        }
    }
}
