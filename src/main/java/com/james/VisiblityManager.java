package com.james;

public class VisiblityManager {

    Mana mana;
    TitleScreen titleScreen;
    KarmaGUI karmaGUI;

    public VisiblityManager(Mana manaScreen, TitleScreen tScreen, KarmaGUI karma){
        mana = manaScreen;
        titleScreen = tScreen;
        KarmaGUI karmaGUI = new KarmaGUI(new KarmaDB());
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
        karmaGUI.setVisible(true);
    }
}
