package com.james;

import java.util.Random;

public class Enemy {
    String name;
    int hp;
    int baseDamage;
    int maxDamage;
    int expWorth;
    Random rnd = new Random();
    Player player;


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public Enemy(String name, int hp, int baseDamage, int maxDamage, int expWorth) {
        this.name = name;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.maxDamage = maxDamage;
        this.expWorth = expWorth;
    }






}
