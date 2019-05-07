package com.james;

public class Sequence {
    Game game;
    Mana mana;
    TitleScreen titleScreen;
    VisiblityManager visiblityManager;
    Player player = new Player();

    //Choice Battle Interface
    String battleChoice1 = "Attack";
    String battleChoice2 = "Magic";
    String battleChoice3 = "Use Item";
    String battleChoice4 = "Run";



    public Sequence(Game gameStory, Mana manaStory, TitleScreen titleStory, VisiblityManager visibiltyStory){
        game = gameStory;
        mana = manaStory;
        titleScreen = titleStory;
        visiblityManager = visibiltyStory;
    }

    public void defaultStats(){
        player.lvl = 1;
        player.exp = 0;
        player.hp = 50;
        player.maxHp = 50;
        player.mana = 25;
        player.baseDamage = 5;
        player.maxDamage = 10;
    }

    public void selectChoice(String nextChoice){
        switch (nextChoice){
            case "Who are you?": whoAreYou(); break;
            case "Chest Appears": chest(); break;
            case "Open Chest": selectWeapon(); break;
            case "Refuse": standStill(); break;
            case "Sword": selectSword(); break;
            case "Bow" : selectBow(); break;
            case "Orb" : selectOrb(); break;
            case "First Battle!" : firstBattle(); break;

        }

    }

    public void awaken() {
        mana.adventureText.setText("<You awake from your slumber. You try to recall why you are on this stone platform with etched in symbols" +
               ", but you cant remember anything. You then here a mysterious elderly voice.>\nMysterious Voice: You have finally awaken");
        mana.choice1.setText("Who are you?");
        mana.choice2.setText("");
        mana.choice3.setText("");
        mana.choice4.setText("");

        game.nextChoice1 = "Who are you?";
    }

    public void whoAreYou() {
        mana.adventureText.setText("Mysterious Voice: That doesnt matter....yet. I just hope the GrandMaster was right about you");
        mana.choice1.setText("GrandMaster?");
        mana.choice2.setText("");
        mana.choice3.setText("");
        mana.choice4.setText("");

        game.nextChoice1 = "Chest Appears";
    }

    public void chest() {
        mana.adventureText.setText("Please just open the chest.\n <A chest appears in front of you>");
        mana.choice1.setText("Open the chest");
        mana.choice2.setText("(Refuse)'Not until you tell me my I'm here and who you are!'");
        mana.choice3.setText("");
        mana.choice4.setText("");

        game.nextChoice1 = "Open Chest";
        game.nextChoice2 = "Refuse";
    }

    public void selectWeapon() {
        mana.adventureText.setText("<In the chest you see 3 items: A sword, a bow, and a orb>\n Mysterious Voice: We..Or I should say you don't have all day. Choooosseeee Yoooouuuuurrr Weeeeaaappppooonn!");
        mana.choice1.setText("Pick up the sword");
        mana.choice2.setText("Pick up the bow.");
        mana.choice3.setText("Pick up the orb.");
        mana.choice4.setText("");

        game.nextChoice1 = "Sword";
        game.nextChoice2 = "Bow";
        game.nextChoice3 = "Orb";
    }

    public void standStill() {
        mana.adventureText.setText("Ha! Well, looks like we are at a standstill. I'd just open the chest if I were you...");
        mana.choice1.setText(">>>");
        mana.choice2.setText("");
        mana.choice3.setText("");
        mana.choice4.setText("");

        game.nextChoice1 = "Chest Appears";
    }

    public void selectSword() {
        mana.adventureText.setText("Mysterious Voice: Basic, yet effective...");
        mana.choice1.setText(">>>");
        mana.choice2.setText("");
        mana.choice3.setText("");
        mana.choice4.setText("");

        game.nextChoice1 = "First Battle!";

    }

    public void selectBow() {
        mana.adventureText.setText("Mysterious Voice: I hope you know how to use that!\n <Mysterious Voice Laughs>");
        mana.choice1.setText(">>>");
        mana.choice2.setText("");
        mana.choice3.setText("");
        mana.choice4.setText("");

        game.nextChoice1 = "First Battle!";

    }

    public void selectOrb() {
        mana.adventureText.setText("Mysterious Voice: Ha! Do you even know what that is?!");
        mana.choice1.setText(">>>");
        mana.choice2.setText("");
        mana.choice3.setText("");
        mana.choice4.setText("");

        game.nextChoice1 = "First Battle!";

    }

    public void firstBattle() {
        mana.adventureText.setText("Looks like you are going to have to use it!\n A human bandit charges you!");
        mana.choice1.setText(battleChoice1);
        mana.choice2.setText(battleChoice2);
        mana.choice3.setText(battleChoice3);
        mana.choice4.setText(battleChoice4);

    }


}
