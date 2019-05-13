package com.james;

import java.util.Random;

public class Sequence {
    Game game;
    Mana mana;
    TitleScreen titleScreen;
    VisiblityManager visiblityManager;
    Player player = new Player();
    Enemy bandit = new Enemy("Bandit", 25,5,10, 25);
    Enemy druid = new Enemy("Druid", 40, 8, 15, 40);
    Magic fireBall = new Magic("Fireball", 15,22,5);
    Magic heal = new Magic("Heal", 7, 11,5);
    Magic druidHeal  = new Magic("Druid Heal", 12, 20,10);
    Item potion = new Item("Potion", 25);
    Item sword = new Item("Sword", 5);
    Item bow = new Item("Bow", 5);
    Item orb = new Item("Orb", 5);
    Item longSword = new Item("Long Sword", 10);
    Item darkSword = new Item("Dark Sword", 15);

    Random rnd = new Random();


    //Events & Spells
    boolean travelerUnderRock = true;
    boolean hasHealing = false;
    boolean druidHealing = false;



    //Choice Battle Interface
    String battleChoice1 = "Attack";
    String battleChoice2 = "Use Magic";
    String battleChoice3 = "Use Item";

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
        mana.manaLabel.setText("" + player.mana);
        mana.expLabel.setText("" + player.exp);

    }



    public void selectChoice(String nextChoice){
        switch (nextChoice){
            //Game Cases
            case "Level Up": levelUp();break;
            //Battle Cases
            case "Use Item": useItem(); break;
            case "Use Magic": useMagic();break;
            //Magic Cases
            case "Fire": fire(); break;
            case "Heal": heal(); break;
            case "Druid Heal": healTwo();break;
            //Story cases
            case "Who are you?": whoAreYou(); break;
            case "Chest Appears": chest(); break;
            case "Open Chest": selectWeapon(); break;
            case "Refuse": standStill(); break;
            //Story cases - Weapon Selection
            case "Sword": selectSword(); break;
            case "Bow" : selectBow(); break;
            case "Orb" : selectOrb(); break;
            //First Battle!
            case "First Battle!" : firstBattle(); break;
            case "Attack Bandit" : attackBandit(); break;
            case "Bandit Attack" : banditAttack(); break;
            case "Bandit Victory": banditVictory(); break;
            //Story cases - Phase 2
            case "After Bandit Battle" : afterBanditBattle(); break;
            case "Just Murder": twoPaths(); break;
            case "Doubt It": doubtIt(); break;
            //Story cases - Forest
            case "Forest One": forestOne();break;
            case "Help Traveler": helpTraveler(); break;
            case "Forest Two": forestTwo();break;
            case "Rob Traveler": robTraveler();break;
            case "Druid Battle": druidBattle();break;
            case "Attack Druid": attackDruid();break;
            case "Druid Attack": druidAttack();break;
            case "Druid Victory": druidVictory();break;
            case "Forest Three": forestThree();break;
            case "Potion Lion": potionLion();break;
            case "Kill Lion": killLion();break;
            case "Heal Lion": healLion();break;
            //Story cases Phase 3
            case "Dark Wizard": darkWizard();break;

            //Dead
            case "Defeat": defeat();
            case "Restart": restart();


        }

    }
    //Game Methods
    public void levelUp() {
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        player.lvl = player.lvl + 1;
        mana.levelLabel.setText("" + player.lvl);
        mana.expBar.setMaximum(100);
        if (player.exp == 40) {
        mana.expBar.setValue(0);
        } else { }

        player.exp = 0;
        player.hp = 75;
        mana.playerHpLabel.setText("" + player.hp);
        player.maxHp = 75;
        player.mana = 40;
        mana.manaLabel.setText("" + player.hp);
        player.baseDamage = 8;
        player.maxDamage = 16;

        mana.adventureText.setText("Congratulations! You leveled up! You are now level 2!");
        mana.choice1.setText(">>>");

        game.nextChoice1 = "Forest Three";
    }

    //Battle Methods

    public void useItem() {
        mana.useItemButton.setVisible(true);

        mana.adventureText.setText("Please select an item to use");
        mana.choice1.setText("Go back");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if (player.exp == 0) {
            game.nextChoice1 = "First Battle!";
        } else if (player.exp >= 25 && travelerUnderRock) {
            game.nextChoice1 = "Druid Battle";} else {}
    }

    public void itemEffect() {

        if (mana.inventoryList.getSelectedValue() == "Potion"){
            player.hp = player.hp + potion.effect;
            if (player.hp > player.maxHp) {
                player.hp = player.maxHp;
            }
            mana.playerHpLabel.setText("" + player.hp);

            mana.adventureText.setText("You have gained 25 health.");

            mana.choice1.setText(">>>");
            mana.choice2.setVisible(false);
            mana.choice3.setVisible(false);

            mana.useItemButton.setVisible(false);

            if (player.exp == 0) {
                game.nextChoice1 = "Bandit Attack";
            } else if (player.exp >= 25 && travelerUnderRock) {
                game.nextChoice1 = "Druid Attack";
            } else {
                game.nextChoice1 = "Boss Attack!";
            }
        }
    }

    public void useMagic() {
        if (player.exp == 0) {
            mana.choice1.setText(">>>");
            mana.choice2.setVisible(false);
            mana.choice3.setVisible(false);
            mana.adventureText.setText("You have no magic to use");
            game.nextChoice1 = "First Battle!";
        } else {
            if (hasHealing) {
                mana.choice2.setVisible(true);
            }
            mana.adventureText.setText("Select a Magic");
            mana.choice1.setText("Fireball ManaCost: 5");
            game.nextChoice1 = "Fire";
            mana.choice2.setVisible(true);
            if (druidHealing) {
                mana.choice2.setText("Druid Heal");
            } else { mana.choice2.setText("Heal");
            mana.choice3.setVisible(false);
        }}

    }
    //Magic

    public void fire() {
        mana.useItemButton.setVisible(false);

        int magicDamage = rnd.nextInt(fireBall.maxDamage - fireBall.baseDamage + 1) + fireBall.baseDamage;

        mana.adventureText.setText("You hurl a fireball at the " + druid.name + " and dealt " + magicDamage + " damage!");
        druid.hp = druid.hp - magicDamage;

        player.mana = player.mana - fireBall.manaCost;
        mana.manaLabel.setText("" + player.mana);

        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if (druid.hp > 0){
            game.nextChoice1 = "Druid Attack";
        } else {
            game.nextChoice1 = "Druid Victory";
        }


    }

    public void heal() {
        mana.useItemButton.setVisible(false);

        int healAmount = rnd.nextInt(heal.maxDamage - heal.baseDamage + 1) + heal.baseDamage;

        mana.adventureText.setText("You heal yourself for " + healAmount + " health points!");
        player.hp = player.hp + healAmount;
        if (player.hp > player.maxHp) {
            player.hp = player.maxHp;
        }
        mana.playerHpLabel.setText("" + player.hp);

        player.mana = player.mana - heal.manaCost;
        mana.manaLabel.setText("" + player.mana);

        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

//        if (druid.hp > 0){
//            game.nextChoice1 = "Druid Attack";
//        } else {
//            game.nextChoice1 = "Druid Victory";
//        }


    }

    public void healTwo() {
        mana.useItemButton.setVisible(false);

        int healAmount = rnd.nextInt(druidHeal.maxDamage - druidHeal.baseDamage + 1) + druidHeal.baseDamage;

        mana.adventureText.setText("You heal yourself for " + healAmount + " health points!");
        player.hp = player.hp + healAmount;
        if (player.hp > player.maxHp) {
            player.hp = player.maxHp;
        }
        mana.playerHpLabel.setText("" + player.hp);

        player.mana = player.mana - druidHeal.manaCost;
        mana.manaLabel.setText("" + player.mana);

        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

    }
    //Story

    public void awaken() {
        mana.adventureText.setText("<You awake from your slumber. You try to recall why you are on this stone platform with etched in symbols" +
               ", but you cant remember anything. You then here a mysterious elderly voice.>\nMysterious Voice: You have finally awaken");
        mana.choice1.setText("Who are you?");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Who are you?";
    }

    public void whoAreYou() {
        mana.adventureText.setText("Mysterious Voice: That doesnt matter....yet. I just hope the GrandMaster was right about you");
        mana.choice1.setText("GrandMaster?");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Chest Appears";
    }

    public void chest() {
        mana.adventureText.setText("Please just open the chest.\n <A chest appears in front of you>");
        mana.choice1.setText("Open the chest");
        mana.choice2.setVisible(true);
        mana.choice2.setText("(Refuse)'Not until you tell me my I'm here and who you are!'");

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

        game.nextChoice1 = "Sword";
        game.nextChoice2 = "Bow";
        game.nextChoice3 = "Orb";
    }

    public void standStill() {
        mana.adventureText.setText("Ha! Well, looks like we are at a standstill. I'd just open the chest if I were you...");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Chest Appears";
    }

    public void selectSword() {
        mana.addSword();

        player.baseDamage = player.baseDamage + sword.effect;
        player.maxDamage = player.maxDamage + sword.effect;

    mana.adventureText.setText("Mysterious Voice: Basic, yet effective...");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "First Battle!";

    }

    public void selectBow() {
        mana.addBow();

        player.baseDamage = player.baseDamage + bow.effect;
        player.maxDamage = player.maxDamage + bow.effect;

        mana.adventureText.setText("Mysterious Voice: I hope you know how to use that!\n <Mysterious Voice Laughs>");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "First Battle!";

    }

    public void selectOrb() {
        mana.addOrb();

        player.baseDamage = player.baseDamage + orb.effect;
        player.maxDamage = player.maxDamage + orb.effect;

        mana.adventureText.setText("Mysterious Voice: Ha! Do you even know what that is?!");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);


        game.nextChoice1 = "First Battle!";

    }

    public void firstBattle() {
        mana.useItemButton.setVisible(false);
        mana.choice2.setVisible(true);
        mana.choice3.setVisible(true);

        mana.adventureText.setText("Looks like you are going to have to use it!\n A bandit charges you!");
        mana.choice1.setText(battleChoice1);
        mana.choice2.setText(battleChoice2);
        mana.choice3.setText(battleChoice3);


        game.nextChoice1 = "Attack Bandit";
        game.nextChoice2 = "Use Magic";
        game.nextChoice3 = "Use Item";

    }


    public void attackBandit() {
        mana.useItemButton.setVisible(false);

        int playerDamage = rnd.nextInt(player.maxDamage - player.baseDamage + 1) + player.baseDamage;

        mana.adventureText.setText("You attacked the " + bandit.name + " and dealt " + playerDamage + " damage!");
        bandit.hp = bandit.hp - playerDamage;

        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if (bandit.hp > 0){
            game.nextChoice1 = "Bandit Attack";
        } else {
            game.nextChoice1 = "Bandit Victory";
        }
    }

    public void banditAttack() {
        mana.useItemButton.setVisible(false);

        int banditDamage = rnd.nextInt(bandit.maxDamage - bandit.baseDamage + 1) + bandit.baseDamage;

        player.hp = player.hp - banditDamage;
        mana.playerHpLabel.setText("" + player.hp);

        mana.adventureText.setText(bandit.name +" deals " + banditDamage + " to you!");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if(player.hp > 0){
            game.nextChoice1 = "First Battle!";
        } else {
            game.nextChoice1 = "Defeat";
        }
    }

    public void banditVictory(){
        mana.useItemButton.setVisible(false);
        mana.addPotion();

        player.exp = player.exp + bandit.expWorth;
        mana.expLabel.setText("" + player.exp);

        mana.expBar.setValue(player.exp);


        mana.adventureText.setText("Mysterious Voice: Hmmm, the GrandMaster may have picked the right one after all...\nYou recieve a FireSpell and Potion!\nYou have recieved " + bandit.expWorth + " experience points!");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "After Bandit Battle";
    }

    public void afterBanditBattle() {
        mana.choice2.setVisible(true);

        mana.adventureText.setText("Mysterious Voice: There might be some hope for you yet");
        mana.choice1.setText("What are you talking about?! That guy almost killed me!");
        mana.choice2.setText("Wait until I find you.....you are next");
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Just Murder";
        game.nextChoice2 = "Doubt It";
    }

    public void twoPaths() {
        mana.choice2.setVisible(true);

        mana.adventureText.setText("Mysterious Voice: Oh, dont be so dramatic! That was your first test. Now you see that building in near the mountains? Go there for your second trial" +
                "<You see a stone building in the distance. Two paths lead to it: Forest Path and Lake Path");
        mana.choice1.setText("Take Forest Path");
        mana.choice2.setText("Take Lake Path");
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Forest One";
        game.nextChoice2 = "Lake One";
    }

    public void forestOne() {
        mana.choice2.setVisible(true);
        mana.choice3.setVisible(true);

        mana.adventureText.setText("<You walk towards the forest>\n<You hear screaming in the distance and head towards the sound, farther into the forest>" +
                "\nYou stumble upon a traveler stuck under a huge boulder\nTraveler:Please help me!");
        mana.choice1.setText("Help Traveler");
        mana.choice2.setText("Ignore Traveler");
        mana.choice3.setText("Rob Traveler");

        game.nextChoice1 = "Help Traveler";
        game.nextChoice2 = "Forest Two";
        game.nextChoice3 = "Rob Traveler";
    }

    public void doubtIt() {

        player.hp = player.hp - 5;
        mana.playerHpLabel.setText("" + player.hp);

        mana.adventureText.setText("Mysterious Voice: Ha! I doubt it!\n<You feel an agonizing pain in your head.\nYou take 5 damage!\nMysterious Voice: Lets try that again..");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if(player.hp > 0){
            game.nextChoice1 = "Just Murder";
        } else {
            game.nextChoice1 = "Defeat";
        }

    }

    public void helpTraveler() {
        travelerUnderRock = false;

        mana.addPotion();
        mana.addPotion();
        mana.addLongSword();

        player.hp = player.hp - 5;
        mana.playerHpLabel.setText("" + player.hp);

        mana.adventureText.setText("<You push against the boulder, helping the traveler out from under it.\n" + "" +
                "The effort causes you to smash your hand>\n<You take 5 Damage>\nTraveler: Thank you so much! Please take this\n<You recieve 2 Potions and a LongSword\n" +
                "<The traveler walks away, grateful>");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if(player.hp > 0){
            game.nextChoice1 = "Forest Two";
        } else {
            game.nextChoice1 = "Defeat";
        }
    }

    public  void robTraveler() {
        mana.addPotion();
        mana.addDarkSword();

        mana.adventureText.setText("");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Forest Two";
    }


    public void forestTwo() {
        String fightOrSpell = "Druid: You have shown no regard for human life! You must pay!\n<Druid charges you!";

        if (travelerUnderRock){
            mana.adventureText.setText("<You descend farther ino the woods. You spot a lion walking towards you\nThe lion shifts into a"
                    + " man with tribal tattoos all over his body>\nDruid: Hello, human. I am a druid, a protector of the woods and all life that inhabit it.\n" + fightOrSpell);
        } else {
            hasHealing = true;
            player.exp = player.exp + 15;
            mana.expLabel.setText("" + player.exp);
        mana.adventureText.setText("<You descend farther ino the woods. You spot a lion walking towards you\nThe lion shifts into a"
        + " man with tribal tattoos all over his body>\nDruid: Hello, human. I am a druid, a protector of the woods and all life that inhabit it."
        + " The forest observed you help that traveler back there. The forest rewards you.\n <Druid hands you over a scroll. You are rewarded with 15 experience points and a Healing Spell.>");}
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if(travelerUnderRock){
            game.nextChoice1 = "Druid Battle";
        } else {
            game.nextChoice1 = "Level Up";
        }
    }

    public void druidBattle() {
        mana.useItemButton.setVisible(false);
        mana.choice2.setVisible(true);
        mana.choice3.setVisible(true);

        mana.adventureText.setText("What to do?");
        mana.choice1.setText(battleChoice1);
        mana.choice2.setText(battleChoice2);
        mana.choice3.setText(battleChoice3);


        game.nextChoice1 = "Attack Druid";
        game.nextChoice2 = "Use Magic";
        game.nextChoice3 = "Use Item";

    }

    public void attackDruid() {
        mana.useItemButton.setVisible(false);

        int playerDamage = rnd.nextInt(player.maxDamage - player.baseDamage + 1) + player.baseDamage;

        mana.adventureText.setText("You attacked the " + druid.name + " and dealt " + playerDamage + " damage!");
        druid.hp = druid.hp - playerDamage;

        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if (druid.hp > 0){
            game.nextChoice1 = "Druid Attack";
        } else {
            game.nextChoice1 = "Druid Victory";
        }
    }

    public void druidAttack() {
        mana.useItemButton.setVisible(false);

        int druidDamage = rnd.nextInt(druid.maxDamage - druid.baseDamage + 1) + druid.baseDamage;

        player.hp = player.hp - druidDamage;
        mana.playerHpLabel.setText("" + player.hp);

        mana.adventureText.setText(druid.name +" deals " + druidDamage + " to you!");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if(player.hp > 0){
            game.nextChoice1 = "Druid Battle";
        } else {
            game.nextChoice1 = "Defeat";
        }
    }

    public void druidVictory(){
        mana.useItemButton.setVisible(false);
        mana.addPotion();

        player.exp = player.exp + druid.expWorth;
        mana.expLabel.setText("" + player.exp);

        mana.adventureText.setText("<The Druid falls to his knees. He has been defeated.\nYou recieve a Potion!\nYou have recieved " + druid.expWorth + " experience points!");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Level Up";
    }

    public void forestThree(){
        mana.useItemButton.setVisible(false);

        mana.choice2.setVisible(true);
        mana.choice3.setVisible(true);
        if (hasHealing) {
            mana.choice4.setVisible(true);
        }

        mana.adventureText.setText("<After a while of walking through the forest you see another lion.\n The lion seems to be wounded>");
        mana.choice1.setText("Give a bit of Potion");
        mana.choice2.setText("Ignore Lion");
        mana.choice3.setText("Finish Lion Off");
        mana.choice4.setText("(Special)Heal Lion");

        game.nextChoice1 = "Potion Lion";
        game.nextChoice2 = "Dark Wizard";
        game.nextChoice1 = "Kill Lion";
        game.nextChoice1 = "Heal Lion";
    }

    public void potionLion() {
        mana.addPotion();
        mana.addManaPotion();
        mana.addEarthOrb();

        mana.adventureText.setText("<You give the lion a little bit of one of your potions\nThe lion transforms into a human>\n" +
                "Druid: Thank you, adventurer! Here are some items for my gratitude.\n<You receive a Potion, Mana Potion and Earth Orb." +
                "\n<The Druid tranforms into a bird and flies away>");

        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "Dark Wizard";
    }

    public void killLion() {
        mana.addPotion();
        mana.addManaPotion();
        mana.addHeavyBow();

        mana.adventureText.setText("<You strike the lion and put it out of it's misery.\nThe lion transforms into a druid.\n You recieve a Potion, Mana Potion, and Heavy Bow>");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "Dark Wizard";
    }

    public void healLion() {
        mana.addPotion();
        mana.addManaPotion();
        druidHealing = true;

        mana.adventureText.setText("<You cast your healing spell on the lion.\nThe lions wounds disappear and the lion transforms into a human>" +
                "\nDruid: Thank you adventurer! Where did you learn the spell? Only the druids know that! Nonetheless take this scroll. This will improve your healing\n" +
                "<You receive another scroll and learned Druid Healing");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "Dark Wizard";
    }

    public void darkWizard() {

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
