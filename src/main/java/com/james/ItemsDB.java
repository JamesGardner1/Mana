package com.james;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ItemsDB {
    private static final String DB_CONNECTION_URL = "jdbc:sqlite:items.sqlite";

    // SQL statements
    private static final String CREATE_ITEM_TABLE = "CREATE TABLE items (name TEXT, effect INTEGER )";
    private static final String CREATE_INVENTORY_TABLE = "CREATE TABLE inventory (name TEXT, effect INTEGER)";
    private static final String GET_ALL_ITEMS = "SELECT * FROM items";
    Mana mana;
    HashMap<String, Integer> itemsData = getItems();


    ItemsDB() {
        createTable();
    }

   public void createTable() {

        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(CREATE_ITEM_TABLE);


            statement.executeUpdate("INSERT INTO items (name, effect) VALUES ('Sword', 5)");
            statement.executeUpdate("INSERT INTO items (name, effect) VALUES ('Bow', 5)");
            statement.executeUpdate("INSERT INTO items (name, effect) VALUES ('Orb', 5)");
            statement.executeUpdate("INSERT INTO items (name, effect) VALUES ('Potion', 20)");
            statement.executeUpdate("INSERT INTO items (name, effect) VALUES ('Longsword', 10)");


        } catch (SQLException e) {

            if (e.getMessage().contains("(table items already exists)")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
        }



    }

    public HashMap getItems() {
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {

            String fullListQuery = "select * from items";

            ResultSet resultSet = statement.executeQuery(fullListQuery);
            HashMap<String, Integer> itemsData = new HashMap<>();
            while (resultSet.next()) {
                String itemName = resultSet.getString("name");
                int effect = resultSet.getInt("effect");

                itemsData.put(itemName, effect);
            }
        } catch (SQLException e) {

            if (e.getMessage().contains("")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
        }
        return itemsData;
    }







}