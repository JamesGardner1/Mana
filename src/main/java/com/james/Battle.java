package com.james;

public class Battle {
    Player player;
    Enemy enemy;
    Mana mana;


    String battleText = String.format("% has appeared", enemy);
    String battleChoice1 = "Attack";
    String battleChoice2 = "Use Item";
    String battleChoice3 = "Run";
    String battleChoice4 = "";

    String attackText = String.format(enemy.getName() +" receives " + player.attack() + " damage.");




}

