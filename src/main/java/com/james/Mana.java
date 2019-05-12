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

    Item item;
    Player player;
    Game game;



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




        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);

        choice1.setActionCommand("c1");
        choice2.setActionCommand("c2");
        choice3.setActionCommand("c3");
        choice4.setActionCommand("c4");




    }

    public void addPotion() {
        allItemsListModel.addElement("Potion");
    }

    public void addSword() {
        allItemsListModel.addElement("Sword");
    }

    public void addBow() { allItemsListModel.addElement("Bow"); }

    public void addOrb() {
        allItemsListModel.addElement("Orb");
    }

    public void addLongSword() {
        allItemsListModel.addElement("Potion");
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
//                if (inventoryList.getSelectedValue() == "Potion") {
//                    usePotion();
//                }

            }
        });
    }
//    public void usePotion() {
//        player.hp = player.hp + item.potion.effect;
//        playerHpLabel.setText("" + player.hp);
//
//        adventureText.setText("You have gained 25 health.");
//
//        choice1.setText(">>>");
//        choice2.setVisible(false);
//        choice3.setVisible(false);
//        choice4.setVisible(false);
//
//        if (player.exp == 0) {
//            game.nextChoice1 = "Bandit Attack";
//        } else if (player.exp > 25) {
//            game.nextChoice1 = "Wizard Attack";
//        } else {
//            game.nextChoice1 = "Boss Attack!";
//        }
//
//        useItemButton.setVisible(false);
//    }

}


