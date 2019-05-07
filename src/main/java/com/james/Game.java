package com.james;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    //Learned this from How to make a Text Adventure Game with GUI in Java P3 - Adding a function to button
    ChoiceHandler choiceHandler = new ChoiceHandler();
    Mana mana = new Mana(choiceHandler);
    TitleScreen titleScreen = new TitleScreen(choiceHandler);
    VisiblityManager visiblityManager = new VisiblityManager(mana, titleScreen);
    public static void main(String[] args) {

      new Game();


	// write your code here
    }

    public Game(){

        visiblityManager.showTitleScreen();


    }

    public class ChoiceHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String yourChoice = e.getActionCommand();

            switch(yourChoice){
                case "start": break;
                case "c1": break;
                case "c2": break;
                case "c3": break;
                case "c4": break;
            }

        }
    }
}
