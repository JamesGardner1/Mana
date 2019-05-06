package com.james;

import java.util.Random;

public class Enemy {
    String name;
    int hp;
    int baseDamage;
    int maxDamage;
    Random rnd = new Random();
    Player player;

    public String getName() {
        return name;
    }


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

    public Enemy(String name, int hp, int baseDamage, int maxDamage) {
        this.name = name;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.maxDamage = maxDamage;
    }



    public int attack() {
        return rnd.nextInt(maxDamage - baseDamage) + baseDamage;
    }

    public int brace() {
        return this.hp - player.attack();

    }

}
