package com.james;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mana extends JFrame {
    JProgressBar expBar;
    JPanel mainPanel;
    JButton choice1;
    JButton choice2;
    JButton choice3;
    JButton choice4;
    JTextPane adventureText;
    JLabel playerHpLabel;
    JLabel levelLabel;
    JLabel expLabel;
    JLabel manaLabel;
    JList<String> inventoryList;
    JButton useItemButton;


    DefaultListModel<String> allItemsListModel;


    public Mana(Game.ChoiceHandler choiceHandler) {

        allItemsListModel = new DefaultListModel<String>();
        inventoryList.setModel(allItemsListModel);
        inventoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addListeners();


        setContentPane(mainPanel);
        pack();
        setVisible(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        useItemButton.setVisible(false);
        useItemButton.addActionListener(choiceHandler);


        choice4.setVisible(false);

        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);

        choice1.setActionCommand("c1");
        choice2.setActionCommand("c2");
        choice3.setActionCommand("c3");
        choice4.setActionCommand("c4");


        useItemButton.setActionCommand("useitem");

    }

    public void addPotion() {
        allItemsListModel.addElement("Potion");
    }

    public void addManaPotion(){allItemsListModel.addElement("Mana Potion");}

    public void addSword() {
        allItemsListModel.addElement("Sword");
    }

    public void addBow() { allItemsListModel.addElement("Bow"); }

    public void addOrb() {
        allItemsListModel.addElement("Orb");
    }

    //Upgrades
    public void addUpgrade1() {
        if (allItemsListModel.contains("Sword")) {
            allItemsListModel.addElement("Long Sword");
            allItemsListModel.removeElement("Sword");
        } else if (allItemsListModel.contains("Bow")) {
            allItemsListModel.addElement("Heavy Bow");
            allItemsListModel.removeElement("Bow");
        } else {
            allItemsListModel.addElement("Earth Orb");
            allItemsListModel.removeElement("Orb");
        }
    }
    public void addUpgrade2() {
        if (allItemsListModel.contains("Sword")) {
            allItemsListModel.addElement("Dark Blade");
            allItemsListModel.removeElement("Sword");
        } else if (allItemsListModel.contains("Long Sword")) {
            allItemsListModel.addElement("Dark Blade");
            allItemsListModel.removeElement("Long Sword");
        } else if(allItemsListModel.contains("Bow")){
            allItemsListModel.addElement("Dark Bow");
            allItemsListModel.removeElement("Bow");
        } else if(allItemsListModel.contains("Heavy Bow")){
            allItemsListModel.addElement("Dark Bow");
            allItemsListModel.removeElement("Heavy Bow");
        } else if (allItemsListModel.contains("Orb")) {
            allItemsListModel.addElement("Dark Orb");
            allItemsListModel.removeElement("Orb");
        } else if(allItemsListModel.contains("Earth Orb")) {
            allItemsListModel.addElement("Dark Orb");
            allItemsListModel.removeElement("Earth Orb");
        }
    }

    public void addDragonBlade() {
        allItemsListModel.addElement("Dragon Blade");
    }



    public void addListeners() {
        useItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedIndex = inventoryList.getSelectedIndex();


                if (selectedIndex != -1) {
                    allItemsListModel.remove(selectedIndex);
                }else{
                    JOptionPane.showMessageDialog(Mana.this, "Please select an item to use.");
                }


            }
        });
    }

    public void clearInventory() {
        allItemsListModel.clear();
    }


}


