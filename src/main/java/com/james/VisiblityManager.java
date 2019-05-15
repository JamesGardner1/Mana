package com.james;

public class VisiblityManager {

    Mana mana;
    TitleScreen titleScreen;
    KarmaGUI karma;

    public VisiblityManager(Mana manaScreen, TitleScreen tScreen, KarmaGUI kTable){
        mana = manaScreen;
        titleScreen = tScreen;
        karma = kTable;
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
    public void endGame() {
        mana.setVisible(false);
        karma.setVisible(true);
    }
}
