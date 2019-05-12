package com.james;

import java.util.Random;

public class Sequence {
    Game game;
    Mana mana;
    TitleScreen titleScreen;
    VisiblityManager visiblityManager;
    Player player = new Player();
    Enemy bandit = new Enemy("Bandit", 25,5,10, 25);
    Random rnd = new Random();
//    ItemsDB items = new ItemsDB();

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

    public void setUIDefault(){
        mana.levelLabel.setText("" + player.lvl);
        mana.playerHpLabel.setText("" + player.hp);
        mana.manaLabel.setText(String.valueOf(player.mana));
        mana.expLabel.setText(String.valueOf(player.exp));

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
            case "Attack Bandit" : attackBandit(); break;
            case "Bandit Attack" : banditAttack(); break;
            case "Bandit Victory": banditVictory(); break;

        }

    }

    public void awaken() {
        mana.adventureText.setText("<You awake from your slumber. You try to recall why you are on this stone platform with etched in symbols" +
               ", but you cant remember anything. You then here a mysterious elderly voice.>\nMysterious Voice: You have finally awaken");
        mana.choice1.setText("Who are you?");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "Who are you?";
    }

    public void whoAreYou() {
        mana.adventureText.setText("Mysterious Voice: That doesnt matter....yet. I just hope the GrandMaster was right about you");
        mana.choice1.setText("GrandMaster?");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);


        game.nextChoice1 = "Chest Appears";
    }

    public void chest() {
        mana.adventureText.setText("Please just open the chest.\n <A chest appears in front of you>");
        mana.choice1.setText("Open the chest");
        mana.choice2.setVisible(true);
        mana.choice2.setText("(Refuse)'Not until you tell me my I'm here and who you are!'");
        mana.choice3.setText("");
        mana.choice4.setText("");

        game.nextChoice1 = "Open Chest";
        game.nextChoice2 = "Refuse";
    }

    public void selectWeapon() {
        mana.adventureText.setText("<In the chest you see 3 items: A sword, a bow, and a orb>\n Mysterious Voice: We..Or I should say you don't have all day. Choooosseeee Yoooouuuuurrr Weeeeaaappppooonn!");
        mana.choice1.setText("Pick up the sword");
        mana.choice2.setVisible(true);
        mana.choice2.setText("Pick up the bow.");
        mana.choice3.setVisible(true);
        mana.choice3.setText("Pick up the orb.");
        mana.choice4.setText("");

        game.nextChoice1 = "Sword";
        game.nextChoice2 = "Bow";
        game.nextChoice3 = "Orb";
    }

    public void standStill() {
        mana.adventureText.setText("Ha! Well, looks like we are at a standstill. I'd just open the chest if I were you...");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "Chest Appears";
    }

    public void selectSword() {

        mana.adventureText.setText("Mysterious Voice: Basic, yet effective...");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "First Battle!";

    }

    public void selectBow() {
        mana.adventureText.setText("Mysterious Voice: I hope you know how to use that!\n <Mysterious Voice Laughs>");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "First Battle!";

    }

    public void selectOrb() {
        mana.adventureText.setText("Mysterious Voice: Ha! Do you even know what that is?!");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "First Battle!";

    }

    public void firstBattle() {
        mana.choice2.setVisible(true);
        mana.choice3.setVisible(true);
        mana.choice4.setVisible(true);

        mana.adventureText.setText("Looks like you are going to have to use it!\n A " + bandit.name + " charges you!");
        mana.choice1.setText(battleChoice1);
        mana.choice2.setText(battleChoice2);
        mana.choice3.setText(battleChoice3);
        mana.choice4.setText(battleChoice4);

        game.nextChoice1 = "Attack Bandit";
        game.nextChoice2 = "Use Item";

    }


    public void attackBandit() {
        int playerDamage = rnd.nextInt(player.maxDamage - player.baseDamage + 1) + player.baseDamage;

        mana.adventureText.setText("You attacked the " + bandit.name + " and dealt " + playerDamage + " damage!");
        bandit.hp = bandit.hp - playerDamage;

        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        if (bandit.hp > 0){
            game.nextChoice1 = "Bandit Attack";
        } else {
            game.nextChoice1 = "Bandit Victory";
        }
    }

    public void banditAttack() {

        int banditDamage = rnd.nextInt(bandit.maxDamage - bandit.baseDamage + 1) + bandit.baseDamage;

        player.hp = player.hp - banditDamage;
        mana.playerHpLabel.setText("" + player.hp);

        mana.adventureText.setText(bandit.name +" deals " + banditDamage + " to you!");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        if(player.hp > 0){
            game.nextChoice1 = "First Battle!";
        } else {
            game.nextChoice1 = "Defeat";
        }
    }

    public void banditVictory(){
        player.exp = player.exp + bandit.expWorth;
        mana.expLabel.setText("" + player.exp);

        mana.adventureText.setText("Mysterious Voice: Hmmm, the GrandMaster may have picked the right one after all...\nYou recieve a FireSpell and Potion!\nYou have recieved " + bandit.expWorth + " experience points!");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "After Bandit Battle";

    }

    public void afterBanditBattle() {
        mana.choice2.setVisible(true);
        mana.choice3.setVisible(true);

        mana.adventureText.setText("Mysterious Voice: There might be some hope for you yet");
        mana.choice1.setText("What are you talking about?! That guy almost killed me!");
        mana.choice2.setText("Wait until I find you.....you are next");
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "Just Murder";
        game.nextChoice2 = "Doubt it";

    }

    public void twoPaths() {
        mana.choice2.setVisible(true);

        mana.adventureText.setText("Mysterious Voice: Oh, dont be so dramatic! That was your first test. Now you see that building in near the mountains? Go there for your second trial" +
                "<You see a stone building in the distance. Two paths lead to it: Forest Path and Lake Path");
        mana.choice1.setText("Take Forest Path");
        mana.choice2.setText("Take Lake Path");
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "Forest One";
        game.nextChoice2 = "Lake One";

    }

    public void defeat(){
        mana.adventureText.setText("Dang, you died fam.\n\n\nGAME OVER!");

        mana.choice1.setText("Try Again?");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "Restart";

    }

    public void restart() {

        defaultStats();
        visiblityManager.showTitleScreen();

    }


}
