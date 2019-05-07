package com.james;

public class VisiblityManager {

    Mana mana;
    TitleScreen titleScreen;

    public VisiblityManager(Mana manaScreen, TitleScreen tScreen){
        mana = manaScreen;
        titleScreen = tScreen;

    }

    public void showTitleScreen(){
        //Start with the title screen

        titleScreen.setVisible(true);
        mana.setVisible(false);

    }
    public void startGame(){
        titleScreen.setVisible(false);
        mana.setVisible(true);

    }
}
