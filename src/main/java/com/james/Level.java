package com.james;

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





}


