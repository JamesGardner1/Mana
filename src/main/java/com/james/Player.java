package com.james;


import java.util.Random;
import static input.InputUtils.stringInput;


public class Player {
    String name;
    int lvl;
    int exp;
    int hp;
    int maxHp;
    int mana;
    int baseDamage;
    int maxDamage;
    Random rnd = new Random();
    Enemy enemy;


    public Player(String name, int lvl, int exp, int hp, int maxHp, int mana, int baseDamage, int maxDamage) {
        this.name = name;
        this.lvl = lvl;
        this.exp = exp;
        this.hp = hp;
        this.maxHp = maxHp;
        this.mana = mana;
        this.baseDamage = baseDamage;
        this.maxDamage = maxDamage;
    }



//    public String createPlayer() {
//        name = stringInput("What is your name?");
//        return name;
//    }
//
    public int attack() {
        return rnd.nextInt(maxDamage - baseDamage) + baseDamage;
    }

    public int brace() {
        return hp - enemy.attack();

    }



}
