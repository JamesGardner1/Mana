package com.james;

import java.util.ArrayList;
import java.util.HashMap;

public class Item {
    String name;
    int effect;

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




    ArrayList<Object> itemList = getItemList();

    public ArrayList<Object> getItemList() {
        itemList.add(potion);
        itemList.add(sword);
        itemList.add(bow);
        itemList.add(orb);
        itemList.add(longSword);

        return itemList;
    }


}

