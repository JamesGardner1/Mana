package com.james;

import java.util.ArrayList;
import java.util.HashMap;

public class Item {
    String name;
    int effect;

    Game game;

    Player player;
    Mana mana;


    public Item(String name, int effect) {
        this.name = name;
        this.effect = effect;
    }

    Item potion = new Item("Potion", 25);
    Item sword = new Item("Sword", 5);
    Item bow = new Item("Bow", 5);
    Item orb = new Item("Orb", 5);
    Item longSword = new Item("Long Sword", 10);

    public void usePotion() {
        player.hp = player.hp + potion.effect;
        mana.playerHpLabel.setText("" + player.hp);

        mana.adventureText.setText("You have gained 25 health.");

        mana.choice1.setText(">>>");
        mana.choice2.setVisible(false);
        mana.choice3.setVisible(false);
        mana.choice4.setVisible(false);

        if (player.exp == 0) {
            game.nextChoice1 = "Bandit Attack";
        } else if (player.exp > 25) {
            game.nextChoice1 = "Wizard Attack";
        } else {
            game.nextChoice1 = "Boss Attack!";
        }

        mana.useItemButton.setVisible(false);


    }




//    ArrayList<Object> itemList = getItemList();
//
//    public ArrayList<Object> getItemList() {
//        itemList.add(potion);
//        itemList.add(sword);
//        itemList.add(bow);
//        itemList.add(orb);
//        itemList.add(longSword);
//
//        return itemList;
//    }


}

