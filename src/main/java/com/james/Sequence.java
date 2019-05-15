package com.james;


import java.util.Random;

public class Sequence {
    Game game;
    Mana mana;
    TitleScreen titleScreen;
    VisiblityManager visiblityManager;
    KarmaDB karma = new KarmaDB();
    KarmaGUI generateKarma = new KarmaGUI(karma);
    Player player = new Player();
    Enemy bandit = new Enemy("Bandit", 25, 5, 10, 25);
    Enemy druid = new Enemy("Druid", 40, 8, 15, 40);
    Enemy ghost = new Enemy("Ghost", 55, 10, 18, 45);
    Enemy wizard = new Enemy("Wizard", 75, 13, 22, 100);
    Magic fireBall = new Magic("Fireball", 15, 25, 5);
    Magic heal = new Magic("Heal", 10, 18, 5);
    Magic druidHeal = new Magic("Druid Heal", 18, 30, 10);
    Magic waterBlast = new Magic("Water Blast", 21, 30,10);
    Item potion = new Item("Potion", 30);
    Item sword = new Item("Sword", 5);
    Item bow = new Item("Bow", 5);
    Item orb = new Item("Orb", 5);

    Random rnd = new Random();


    //Events & Spells
    boolean travelerUnderRock = true;
    boolean hasHealing = false;
    boolean druidHealing = false;
    boolean lakePath = false;
    boolean fishermanHelped = false;
    boolean hasWaterBlast = false;
    boolean ghostStillExists = true;
    boolean finalBattle = false;




    //Choice Battle Interface
    String battleChoice1 = "Attack";
    String battleChoice2 = "Use Magic";
    String battleChoice3 = "Use Item";

    public Sequence(Game gameStory, Mana manaStory, TitleScreen titleStory, VisiblityManager visibiltyStory) {
        game = gameStory;
        mana = manaStory;
        titleScreen = titleStory;
        visiblityManager = visibiltyStory;
    }

    public void defaultStats() {
        player.lvl = 1;
        player.exp = 0;
        player.hp = 50;
        player.maxHp = 50;
        player.mana = 25;
        player.baseDamage = 5;
        player.maxDamage = 10;
    }

    public void setUIDefault() {
        //Set the player Stats and UI
        mana.levelLabel.setText("" + player.lvl);
        mana.playerHpLabel.setText("" + player.hp);
        mana.healthBar.setValue(player.hp);
        mana.healthBar.setMaximum(50);
        mana.manaLabel.setText("" + player.mana);
        mana.manaBar.setValue(player.mana);
        mana.expLabel.setText("" + player.exp);


    }


    public void selectChoice(String nextChoice) {
        switch (nextChoice) {
            //Game Cases
            case "Level Up": levelUp();break;

            //Battle Cases
            case "Use Item": useItem();break;
            case "Use Magic": useMagic();break;

            //Magic Cases
            case "Fire": fire();break;
            case "Heal": heal();break;
            case "Druid Heal": healTwo();break;
            case "Water Blast": water();break;

            //Story cases
            case "Who are you?":whoAreYou();break;
            case "Chest Appears":chest();break;
            case "Open Chest":selectWeapon();break;
            case "Refuse": standStill();break;
            case "Sword": selectSword();break;
            case "Bow": selectBow();break;
            case "Orb": selectOrb();break;
            case "After Bandit Battle": afterBanditBattle();break;
            case "Just Murder": twoPaths();break;
            case "Doubt It": doubtIt();break;

            //Story cases - Forest
            case "Forest One": forestOne();break;
            case "Help Traveler": helpTraveler();break;
            case "Forest Two": forestTwo();break;
            case "Rob Traveler": robTraveler();break;
            case "Forest Three": forestThree();break;
            case "Potion Lion": potionLion();break;
            case "Kill Lion": killLion();break;
            case "Heal Lion": healLion();break;

            //Story Cases - Lake
            case "Lake One": lakeOne();break;
            case "Help Fisherman": helpFisherman();break;
            case "Ignore Fisherman": forestTwo();break;
            case "Help Bandit": helpBandit();break;
            case "Lake Two": lakeTwo();break;
            case "Yes Pizza": yesPizza();break;
            case "No Pizza": noPizza();break;
            case "Neutral Pizza": neutralPizza();break;
            case "Lake Three": lakeThree();break;

            //Story cases Phase 3
            case "Dark Wizard": darkWizard();break;

            //BattleCases
            //Bandit
            case "First Battle!": firstBattle();break;
            case "Bandit River Battle": banditRiverBattle();break;
            case "Attack Bandit": attackBandit();break;
            case "Bandit Attack": banditAttack();break;
            case "Bandit Victory": banditVictory();break;
            case "Bandit Fisherman Victory": banditFishermanVictory();break;
            //Druid
            case "Druid Battle": druidBattle();break;
            case "Attack Druid": attackDruid();break;
            case "Druid Attack": druidAttack();break;
            case "Druid Victory": druidVictory();break;
            //Ghost
            case "Ghost Battle": ghostBattle();break;
            case "Attack Ghost": attackGhost();break;
            case "Ghost Attack": ghostAttack();break;
            case "Ghost Victory": ghostVictory();break;
            //Dark Wizard
            case "Wizard Battle": wizardBattle();break;
            case "Attack Wizard": attackWizard();break;
            case "Wizard Attack": wizardAttack();break;
            case "Wizard Special Attack": wizardSpecialAttack();break;
            case "Wizard Victory": wizardVictory();break;
            //End Game
            case "Spare Wizard": spareWizard();break;
            case "Kill Wizard": killWizard();break;
            case "End Game": endGame();break;
            case "Karma": showKarma();break;

            //Dead
            case "Defeat": defeat();break;
            case "Restart": restart();break;


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
        } else {
        }

        player.exp = 0;
        player.hp = 75;
        mana.playerHpLabel.setText("" + player.hp);
        mana.healthBar.setValue(player.hp);
        player.maxHp = 75;
        mana.healthBar.setMaximum(player.maxHp);
        player.mana = 40;
        mana.manaLabel.setText("" + player.mana);
        player.baseDamage = 8;
        player.maxDamage = 16;

        mana.adventureText.setText("Congratulations! You leveled up! You are now level 2!");
        mana.choice1.setText(">>>");

        //Levels Up Depending on where the character is at in the story
        if (lakePath) {
            game.nextChoice1 = "Lake Two";
        } else {
            game.nextChoice1 = "Forest Three";
        }
    }

    //Battle Methods

    public void useItem() {
        mana.useItemButton.setVisible(true);

        mana.adventureText.setText("Please select an item to use");
        mana.choice1.setText("Go back");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if (player.exp == 0 && player.lvl == 1) {
            game.nextChoice1 = "First Battle!";
        } else if (player.exp >= 25 && travelerUnderRock && !lakePath) {
            game.nextChoice1 = "Druid Battle";
        } else if (player.exp >= 25 && lakePath && ghostStillExists) {
            game.nextChoice1 = "Bandit River Battle";
        } else if (player.exp >= 40 && player.exp < 90 && lakePath) {
            game.nextChoice1 = "Ghost Battle";
        } else {
            game.nextChoice1 = "Wizard Battle";
        }
    }

    public void itemEffect() {
        // Use potions help from StackOverflow
        if (mana.inventoryList.getSelectedValue() == "Potion") {
            player.hp = player.hp + potion.effect;

            //Makes sure that your hp doesnt go above maximum
            if (player.hp > player.maxHp) {
                player.hp = player.maxHp;
            }
            mana.playerHpLabel.setText("" + player.hp);
            mana.healthBar.setValue(player.hp);
            mana.adventureText.setText("You have gained 30 health.");

            mana.choice1.setText(">>>");
            mana.choice2.setVisible(false);
            mana.choice3.setVisible(false);

            mana.useItemButton.setVisible(false);

            if (lakePath && ghostStillExists && !finalBattle) {
                game.nextChoice1 = "Bandit Attack";
            } else if (player.exp >= 25 && travelerUnderRock && !lakePath) {
                game.nextChoice1 = "Druid Attack";
            } else if (player.exp >= 25 && lakePath && !ghostStillExists) {
                game.nextChoice1 = "Ghost Attack";
            } else {
                game.nextChoice1 = "Wizard Attack";
            }
        }

        if (mana.inventoryList.getSelectedValue() == "Mana Potion") {
            player.mana = player.mana + potion.effect;


            mana.manaLabel.setText("" + player.mana);
            mana.adventureText.setText("You have gained 25 mana points.");

            mana.choice1.setText(">>>");
            mana.choice2.setVisible(false);
            mana.choice3.setVisible(false);

            mana.useItemButton.setVisible(false);

            if (player.exp == 0 || lakePath) {
                game.nextChoice1 = "Bandit Attack";
            } else if (player.exp >= 25 && travelerUnderRock) {
                game.nextChoice1 = "Druid Attack";
            } else if (player.exp >= 40 && lakePath) {
                game.nextChoice1 = "Ghost Attack";
            } else {
                game.nextChoice1 = "Wizard Attack!";
            }
        }
    }



    public void useMagic() {
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if (hasHealing) {
            mana.choice2.setVisible(true);
        }

        if (hasWaterBlast) {
            mana.choice3.setVisible(true);
        }


        if (player.exp == 0 && player.lvl == 1) {
            mana.choice1.setText(">>>");
            mana.choice2.setVisible(false);
            mana.choice3.setVisible(false);
            mana.adventureText.setText("You have no magic to use");
            game.nextChoice1 = "First Battle!";
        } else {
            mana.adventureText.setText("Select a Magic");
            mana.choice1.setText("Fireball Mana Cost: 5");

            if (druidHealing) {
                mana.choice2.setText("Druid Heal Mana Cost: 10");
                game.nextChoice2 = "Druid Heal";
            } else { mana.choice2.setText("Heal Mana Cost: 5");
            game.nextChoice2 = "Heal";}

            mana.choice3.setText("Water Blast Mana Cost: 10");

            game.nextChoice1 = "Fire";
            game.nextChoice3 = "Water Blast";
        }
    }


    //Magic

    public void fire() {
        mana.useItemButton.setVisible(false);
            int magicDamage = rnd.nextInt(fireBall.maxDamage - fireBall.baseDamage + 1) + fireBall.baseDamage;
            if (player.exp == 25 && lakePath && ghostStillExists && player.mana >= 5) {
                mana.adventureText.setText("You hurl a fireball at the " + bandit.name + " and dealt " + magicDamage + " damage!");
                bandit.hp = bandit.hp - magicDamage;

                player.mana = player.mana - fireBall.manaCost;
                mana.manaLabel.setText("" + player.mana);

                mana.choice1.setText(">>>");
                mana.choice2.setVisible(false);
                mana.choice3.setVisible(false);

            if (bandit.hp > 0){
                game.nextChoice1 = "Bandit Attack";
            } else {
                game.nextChoice1 = "Bandit Fisherman Victory";
            }
        } else if (player.exp == 25 && !lakePath  && player.mana >= 5) {

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


    } else if (!ghostStillExists && lakePath && !finalBattle  && player.mana >= 5) {
                mana.adventureText.setText("You hurl a fireball at the " + ghost.name + " and dealt " + magicDamage + " damage!");
                ghost.hp = ghost.hp - magicDamage;

                player.mana = player.mana - fireBall.manaCost;
                mana.manaLabel.setText("" + player.mana);

                mana.choice1.setText(">>>");
                mana.choice2.setVisible(false);
                mana.choice3.setVisible(false);

                if (ghost.hp > 0){
                    game.nextChoice1 = "Ghost Attack";
                } else {
                    game.nextChoice1 = "Ghost Victory";
                }
            } else if (finalBattle  && player.mana >= 5){
                mana.adventureText.setText("You hurl a fireball at the Dark Wizard and dealt " + magicDamage + " damage!");
                wizard.hp = wizard.hp - magicDamage;

                player.mana = player.mana - fireBall.manaCost;
                mana.manaLabel.setText("" + player.mana);

                mana.choice1.setText(">>>");
                mana.choice2.setVisible(false);
                mana.choice3.setVisible(false);

                if (wizard.hp > 0){
                    game.nextChoice1 = "Wizard Attack";
                } else {
                    game.nextChoice1 = "Wizard Victory";
                }
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
        mana.healthBar.setValue(player.hp);

        player.mana = player.mana - heal.manaCost;
        mana.manaLabel.setText("" + player.mana);
        mana.manaBar.setValue(player.mana);

        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if (!lakePath && player.lvl < 2) {
            game.nextChoice1 = "Druid Attack";
        } else if (lakePath && player.lvl < 2) {
            game.nextChoice1 = "Bandit Attack";
        } else if (lakePath && player.exp < 90) {
            game.nextChoice1 = "Ghost Attack";
        } else {
            game.nextChoice1 = "Wizard Attack";
        }


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
        mana.healthBar.setValue(player.hp);

        player.mana = player.mana - druidHeal.manaCost;
        mana.manaLabel.setText("" + player.mana);
        mana.manaBar.setValue(player.mana);

        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);


        game.nextChoice1 = "Wizard Attack";



    }

    public void water() {
        mana.useItemButton.setVisible(false);
        int magicDamage = rnd.nextInt(waterBlast.maxDamage - waterBlast.baseDamage + 1) + waterBlast.baseDamage;
       if (player.exp > 40 && lakePath) {
            mana.adventureText.setText("You hurl a waterblast at the " + ghost.name + " and dealt " + magicDamage + " damage!");
            ghost.hp = ghost.hp - magicDamage;

            player.mana = player.mana - waterBlast.manaCost;
            mana.manaLabel.setText("" + player.mana);
            mana.manaBar.setValue(player.mana);


            mana.choice1.setText(">>>");
            mana.choice2.setVisible(false);
            mana.choice3.setVisible(false);

            if (ghost.hp > 0){
                game.nextChoice1 = "Ghost Attack";
            } else {
                game.nextChoice1 = "Ghost Victory";
            }
        } else {
            mana.adventureText.setText("You hurl a water blast at the Dark Wizard and dealt " + magicDamage + " damage!");
            wizard.hp = wizard.hp - magicDamage;

            player.mana = player.mana - waterBlast.manaCost;
            mana.manaLabel.setText("" + player.mana);
            mana.manaBar.setValue(player.mana);

            mana.choice1.setText(">>>");
            mana.choice2.setVisible(false);
            mana.choice3.setVisible(false);

            if (wizard.hp > 0){
                game.nextChoice1 = "Wizard Attack";
            } else {
                game.nextChoice1 = "Wizard Victory";
            }
        }
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
        defaultStats();
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
        bandit.hp = 25;
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

        mana.adventureText.setText("Mysterious Voice: Looks like you are going to have to use it!\n <A bandit charges you!>");
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

        if (player.exp > 1) {
            if (bandit.hp > 0){
            game.nextChoice1 = "Bandit Attack";
        } else {
            game.nextChoice1 = "Bandit Fisherman Victory";
        }} else {
            if (bandit.hp > 0){
                game.nextChoice1 = "Bandit Attack";
            } else {
                game.nextChoice1 = "Bandit Victory";
            }
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

        if (player.exp == 0) {
            if(player.hp > 0){
            game.nextChoice1 = "First Battle!";
            } else {
                game.nextChoice1 = "Defeat"; }
        } else {
            if(player.hp > 0){
                game.nextChoice1 = "Bandit River Battle";
            } else {
                game.nextChoice1 = "Defeat"; }
        }
    }

    public void banditVictory(){
        mana.useItemButton.setVisible(false);
        mana.addPotion();

        player.exp = player.exp + bandit.expWorth;
        mana.expLabel.setText("" + player.exp);

        mana.expBar.setValue(player.exp);


        mana.adventureText.setText("Mysterious Voice: Hmmm, the GrandMaster may have picked the right one after all...\n<You recieve a Fire Spell and Potion!\nYou have recieved " + bandit.expWorth + " experience points!>");
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

    public void doubtIt() {

        player.hp = player.hp - 5;
        mana.playerHpLabel.setText("" + player.hp);
        mana.healthBar.setValue(player.hp);

        mana.adventureText.setText("Mysterious Voice: Ha! I doubt it!\n<You feel an agonizing pain in your head.\nYou take 5 damage!>\nMysterious Voice: Lets try that again..");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if(player.hp > 0){
            game.nextChoice1 = "Just Murder";
        } else {
            game.nextChoice1 = "Defeat";
        }

    }

    public void twoPaths() {
        mana.choice2.setVisible(true);

        mana.adventureText.setText("Mysterious Voice: Oh, dont be so dramatic! That was your first test. Now you see that building near the mountains? Go there for your second trial" +
                "<You see a stone building in the distance. Two paths lead to it: Forest Path and Lake Path");
        mana.choice1.setText("Take Forest Path");
        mana.choice2.setText("Take Lake Path");
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Forest One";
        game.nextChoice2 = "Lake One";
    }

    /// Forest Story

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



    public void helpTraveler() {
        travelerUnderRock = false;
        karma.addKarma("Helped Traveler","Helped Traveler", "Good");
        generateKarma.raiseKarma();

        mana.addPotion();
        mana.addPotion();
        mana.addUpgrade1();

        player.baseDamage = player.baseDamage + 5;
        player.maxDamage = player.maxDamage + 8;

        player.hp = player.hp - 5;
        mana.playerHpLabel.setText("" + player.hp);
        mana.healthBar.setValue(player.hp);

        mana.adventureText.setText("<You push against the boulder, helping the traveler out from under it.\n" + "" +
                "The effort causes you to smash your hand>\n<You take 5 Damage>\nTraveler: Thank you so much! Please take this\n<You receive 2 Potions and a weapon upgrade!\n" +
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

    public void robTraveler() {
        karma.addKarma("Robbed Traveler","You robbed the traveler", "Bad");
//        generateKarma.lowerKarma();

        mana.addPotion();
        mana.addUpgrade2();

        player.baseDamage = player.baseDamage + 9;
        player.maxDamage = player.maxDamage + 15;

        mana.adventureText.setText("<You watch the traveler struggle under the boulder and take the backpack next to him\n" +
                "You receive a potion and a big weapon upgrade!!>");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Forest Two";
    }


    public void forestTwo() {
        String fightOrSpell = "Druid: You have shown no regard for human life! You must pay!\n<Druid charges you!>";

        if (travelerUnderRock){
            druid.hp = 40;
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
        game.nextChoice3 = "Kill Lion";
        game.nextChoice4 = "Heal Lion";
    }

    public void potionLion() {
        karma.addKarma("Helped Lion","Gave lion a potion", "Good");
//        generateKarma.raiseKarma();

        mana.addPotion();
        mana.addManaPotion();

        mana.adventureText.setText("<You give the lion a little bit of one of your potions\nThe lion transforms into a human>\n" +
                "Druid: Thank you, adventurer! Here are some items for my gratitude.\n<You receive a Potion, Mana Potion!>" +
                "\n<The Druid tranforms into a bird and flies away>");

        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "Dark Wizard";
    }

    public void killLion() {
        karma.addKarma("Killed Lion","Killed the wounded lion", "Bad");
//        generateKarma.lowerKarma();

        mana.addPotion();
        mana.addManaPotion();

        mana.adventureText.setText("<You strike the lion and put it out of it's misery.\nThe lion transforms into a druid.\n You recieve a Potion, Mana Potion, and a Weapon Upgrade!");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        game.nextChoice1 = "Dark Wizard";
    }

    public void healLion() {
        karma.addKarma("Helped Lion","Casted a healing spell on the lion", "Good");
//        generateKarma.raiseKarma();

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

    // Lake Story

    public void lakeOne() {
        lakePath = true;
        mana.choice2.setVisible(true);
        mana.choice3.setVisible(true);

        mana.adventureText.setText("<You walk towards the lake.\nYou hear someone crying for help." +
                "\nYou stumble upon a fisherman getting robbed by a bandit.>\nFisherman: Please help me!");
        mana.choice1.setText("Help Fisherman");
        mana.choice2.setText("Ignore Fisherman");
        mana.choice3.setText("Help Bandit");

        game.nextChoice1 = "Help Fisherman";
        game.nextChoice2 = "Lake Two";
        game.nextChoice3 = "Help Bandit";
    }

    public void helpFisherman() {
        bandit.hp = 25;
        karma.addKarma("Helped Fisherman","Helped fisherman from getting robbed from bandit", "Good");
//        generateKarma.raiseKarma();

        fishermanHelped = true;
        mana.adventureText.setText("<You come to the aid of the fisherman. The bandit charges you!>");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Bandit River Battle";
    }

    public void helpBandit() {
        karma.addKarma("Helped Bandit","Helped Bandit rob the traveler", "Bad");
        bandit.hp = 25;
        mana.addManaPotion();
        mana.addUpgrade1();

//        karma.badFisherman();
//        generateKarma.lowerKarma();

        player.baseDamage = player.baseDamage + 5;
        player.maxDamage = player.maxDamage + 8;

        mana.adventureText.setText("<You decide to help the bandit and you both rob the fisherman and split his belongings.\n" +
                "You recieve a mana potion and a weapon upgrade! You turn around and the bandit charges you.>");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Bandit River Battle";
    }

    ///River Bandit Battle

    public void banditRiverBattle() {
        mana.useItemButton.setVisible(false);
        mana.choice2.setVisible(true);
        mana.choice3.setVisible(true);

        mana.adventureText.setText("<What to do?>\n Bandit: You're Next!");
        mana.choice1.setText(battleChoice1);
        mana.choice2.setText(battleChoice2);
        mana.choice3.setText(battleChoice3);


        game.nextChoice1 = "Attack Bandit";
        game.nextChoice2 = "Use Magic";
        game.nextChoice3 = "Use Item";

    }


    public void banditFishermanVictory() {
        mana.addPotion();

        player.exp = player.exp + bandit.expWorth;
        mana.expLabel.setText("" + player.exp);

        mana.adventureText.setText("<The bandit has been defeated. You look over to the fisherman and his inflicted wounds causes him to die.\nYou recieve a Potion!\nYou have recieved " + bandit.expWorth + " experience points!>");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Level Up";

    }


    public void lakeTwo() {
        mana.choice2.setVisible(true);
        mana.choice3.setVisible(true);

        mana.adventureText.setText("<You continue down the lake path and a hooded mystical man approaches you.>\n" +
                "Mage: Hmmm...I sense a great power within you, adventurer. One you have not the littlest clue about\n" +
                "If you answer this correctly you will be worthy of this scroll:\nDoes pineapple belong on pizza?");
        mana.choice1.setText("Yes");
        mana.choice2.setText("Its up to whom eats the pizza");
        mana.choice3.setText("No");

        game.nextChoice1 = "Yes Pizza";
        game.nextChoice2 = "Neutral Pizza";
        game.nextChoice3 = "No Pizza";
    }

    public void yesPizza() {
        karma.addKarma("Pinneapple","Gross", "Bad");
        generateKarma.lowerKarma();

        player.hp = player.hp - 5;
        mana.playerHpLabel.setText("" + player.hp);
        mana.healthBar.setValue(player.hp);

        mana.adventureText.setText("Mage: That is incorrect!\n" +
                "<The mage hurls a waterblast towards you and launches you into the lake.\nYou take 5 damage>\n" +
                "Mage:Eh, because you seen the spell already...here you go.\n" +
                "<You have received a Water Blast scroll!\nThe mage fades into the distance>");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Lake Three";
    }
    public void noPizza() {
        karma.addKarma("No Pinneapple","Most Moral decision of the game", "Good");
        generateKarma.raiseKarma();
        mana.addManaPotion();

        mana.adventureText.setText("Mage: That is correct! Here is the water spell scroll and a mana potion for your troubles" +
                "\n<You have recieved a Water Blast scroll and a Mana Potion!>");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Lake Three";
    }
    public void neutralPizza() {
        mana.adventureText.setText("Mage: Please, traveler. This is a simple yes or no question....");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Lake Two";
    }

    public void lakeThree() {
        hasWaterBlast = true;
        ghostStillExists = false;
        String watchedOrHelped = "Ghost Fisherman: Hello adventurer.....you remember me dont you? That bandit ended up taking my life...AND YOU LET IT HAPPEN!\n" +
                "<The ghost charges you!>";

        if (fishermanHelped){
            mana.clearInventory();
            mana.addDragonBlade();

            player.baseDamage = player.baseDamage + 15;
            player.maxDamage = player.maxDamage + 20;


            mana.adventureText.setText("<You are almost at the end of the lake path. The area around you starts to get misty and you hear an eerie voice" +
                    " closing in on you.>\nGhost Fisherman: Hello adventurer...although the wounds I suffered eventually took my life I am greatful for you aid.\n" +
                    "Please take this weapon as a token of my gratitude...it was my great grandfathers.<You recieve the Dragon Blade!!!\nRecieving the Great Dragon Blade makes you drop your whole inventory to make room>>");
            mana.choice1.setText(">>>");
            mana.choice2.setVisible(false);
            mana.choice3.setVisible(false);

            game.nextChoice1 = "Dark Wizard";


        } else {
            mana.adventureText.setText("<You are almost at the end of the lake path. The area around you starts to get misty and you hear an eerie voice closing in on you.>" +
                    "\n " + watchedOrHelped);
            mana.choice1.setText(">>>");
            mana.choice2.setVisible(false);
            mana.choice3.setVisible(false);
            ghost.hp = 55;

            game.nextChoice1 = "Ghost Battle";

        }
    }

    //Ghost Battle
    public void ghostBattle() {

        mana.useItemButton.setVisible(false);
        mana.choice2.setVisible(true);
        mana.choice3.setVisible(true);

        mana.adventureText.setText("<What to do?>\nGhost Fisherman: You shall pay!");
        mana.choice1.setText(battleChoice1);
        mana.choice2.setText(battleChoice2);
        mana.choice3.setText(battleChoice3);


        game.nextChoice1 = "Attack Ghost";
        game.nextChoice2 = "Use Magic";
        game.nextChoice3 = "Use Item";

    }

    public void attackGhost() {
        mana.useItemButton.setVisible(false);

        int playerDamage = rnd.nextInt(player.maxDamage - player.baseDamage + 1) + player.baseDamage;

        mana.adventureText.setText("You attacked the Ghost and dealt " + playerDamage + " damage!");
        ghost.hp = ghost.hp - playerDamage;

        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if (ghost.hp > 0){
            game.nextChoice1 = "Ghost Attack";
        } else {
            game.nextChoice1 = "Ghost Victory";
        }
    }

    public void ghostAttack() {
        mana.useItemButton.setVisible(false);

        int ghostDamage = rnd.nextInt(ghost.maxDamage - ghost.baseDamage + 1) + ghost.baseDamage;

        player.hp = player.hp - ghostDamage;
        mana.playerHpLabel.setText("" + player.hp);

        mana.adventureText.setText("The Ghost deals " + ghostDamage + " to you!");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if(player.hp > 0){
            game.nextChoice1 = "Ghost Battle";
        } else {
            game.nextChoice1 = "Defeat";
        }
    }

    public void ghostVictory(){
        mana.useItemButton.setVisible(false);
        mana.addPotion();
        mana.addPotion();
        mana.addManaPotion();


        player.exp = player.exp + druid.expWorth;
        mana.expLabel.setText("" + player.exp);

        mana.adventureText.setText("<The Ghost disappears back into the mist. He has been defeated.\nYou recieve 2 Potions and a Mana Potion!\nYou have recieved " + ghost.expWorth + " experience points!");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Dark Wizard";
    }


    /// Boss Battle

    public void darkWizard() {
        // Story choice
        String choice = "forest";
        if (lakePath) {
            choice = "lake";
        }
        mana.adventureText.setText("<You exit the " + choice + ".\nThe stone building is only a mile away. A man in a dark robe approaches.>" +
                "\nDark Wizard: Talk around the mage guilds is that the Grand Master has a new chosen one. The word also says that person may be you." +
                "\nIt is quite odd though...I see nothing but disappointment. Test your magicks mortal!\n<The Dark Mage begins casting a spell.>");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        wizard.hp = 75;

        game.nextChoice1 = "Wizard Battle";


    }

    public void wizardBattle() {
        finalBattle = true;
        mana.useItemButton.setVisible(false);
        mana.choice2.setVisible(true);
        mana.choice3.setVisible(true);

        mana.adventureText.setText("<What to do?>\nDark Wizard: You will know nothing but death!");
        mana.choice1.setText(battleChoice1);
        mana.choice2.setText(battleChoice2);
        mana.choice3.setText(battleChoice3);


        game.nextChoice1 = "Attack Wizard";
        game.nextChoice2 = "Use Magic";
        game.nextChoice3 = "Use Item";

    }

    public void attackWizard() {
        mana.useItemButton.setVisible(false);

        int playerDamage = rnd.nextInt(player.maxDamage - player.baseDamage + 1) + player.baseDamage;

        mana.adventureText.setText("You attacked the Wizard and dealt " + playerDamage + " damage!");
        wizard.hp = wizard.hp - playerDamage;

        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        /// Wizard Dark Blast Attack
        if (wizard.hp > 50){
            game.nextChoice1 = "Wizard Attack";
        } else if (wizard.hp < 50 && wizard.hp > 0){
            game.nextChoice1 = "Wizard Special Attack";
        } else {
            game.nextChoice1 = "Wizard Victory";
        }
    }

    public void wizardAttack() {
        mana.useItemButton.setVisible(false);

        int wizardDamage = rnd.nextInt(wizard.maxDamage - wizard.baseDamage + 1) + wizard.baseDamage;

        player.hp = player.hp - wizardDamage;
        mana.playerHpLabel.setText("" + player.hp);

        mana.adventureText.setText(wizard.name +" deals " + wizardDamage + " to you!");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if(player.hp > 0){
            game.nextChoice1 = "Wizard Battle";
        } else {
            game.nextChoice1 = "Defeat";
        }
    }

    public void wizardSpecialAttack() {
        mana.useItemButton.setVisible(false);

        int wizardDamage = rnd.nextInt(wizard.maxDamage - wizard.baseDamage + 5) + wizard.baseDamage;

        player.hp = player.hp - wizardDamage;
        mana.playerHpLabel.setText("" + player.hp);

        mana.adventureText.setText("The Dark Wizard casts a Dark Blast and deals" + wizardDamage + " to you!");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        if(player.hp > 0){
            game.nextChoice1 = "Wizard Battle";
        } else {
            game.nextChoice1 = "Defeat";
        }
    }

    public void wizardVictory(){
        mana.useItemButton.setVisible(false);
        mana.choice2.setVisible(true);

        player.exp = player.exp + wizard.expWorth;
        mana.expLabel.setText("" + player.exp);

        mana.adventureText.setText("<The Dark Wizard falls to the ground and you  received " + wizard.expWorth + " experience points!" +
                "\nDark Wizard: Heh, you really may be the Grand Masters chosen one. You are all still doomed and not ready for whats coming..\n" +
                "<The Dark Wizard is severely weakened>");
        mana.choice1.setText("Spare Wizard");
        mana.choice2.setText("Kill Wizard");
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Spare Wizard";
        game.nextChoice2 = "Kill Wizard";
    }

    public void killWizard() {
        karma.addKarma("Killed Wizard","Took the Dark Wizards life", "Bad");
        generateKarma.lowerKarma();

        player.exp = player.exp + wizard.expWorth;
        mana.expLabel.setText("" + player.exp);

        mana.adventureText.setText("<You launch a fireball into the Dark Wizards face, turning his whole body to ash>");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "End Game";
    }

    public void spareWizard() {
        karma.addKarma("Spared Wizard","Spared the WIzards life", "Good");
        generateKarma.raiseKarma();

        player.exp = player.exp + wizard.expWorth;
        mana.expLabel.setText("" + player.exp);

        mana.adventureText.setText("<You walk away from the Wizard, sparing his life and continue towards the stone building.>");
        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "End Game";
    }


    public void endGame() {
        mana.adventureText.setText("THANK YOU FOR WATCHING ME PLAY THE DEMO VERSION OF THIS GAME!\n" +
                "LETS SEE HOW MANY BAD DECISIONS I MADE.....");
        mana.choice1.setText("Get Karma");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);

        game.nextChoice1 = "Karma";
    }

    public void showKarma() {
        generateKarma.configureTable();
        visiblityManager.endGame();
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
        setUIDefault();
        mana.clearInventory();
        visiblityManager.showTitleScreen();

    }


}
