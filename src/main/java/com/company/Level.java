package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Level {
    int phase;
    ArrayList<String> instances;
    Random rnd = new Random();



    //This method generates instances for the phases/levels
    public ArrayList<String> generateInstance() {

        instances.add("% has appeared!");
        instances.add("% has appeared!");
        instances.add("% has appeared!");
        instances.add("You have stumbled upon a %");
        instances.add("You have taken % damage");
        instances.add("You stumbled upon a scroll! You have obtained %");
        instances.add("You stumbled upon a scroll! You have obtained %");
        instances.add("You have dropped %"); {return instances;}


    }

    public String getInstance() {
        for (int i = 0; i < instances.size(); i++) {
            int event = rnd.nextInt(i);
            }
        }

    }


    void getPhase() {

        System.out.printf("You have awaken, %", name);
        System.out.println("I hope the Grandmaster was right about you...\nMake your way to the Castle -- NOW!!");
        //Choose Weapon
        System.out.printf("I hope you know how to use that %", weapon);
        System.out.println("You are going to need it!\n <Mysterious voice laughs>");
        System.out.println("A shadowy figure appears! Its a bandit!");
        //Battle
        //action
        generateInstance();
        //action
        generateInstance();
        //action
        generateInstance();
        //action
        generateInstance();
        //action
        generateInstance();
        //action
        generateInstance();
    }




}


