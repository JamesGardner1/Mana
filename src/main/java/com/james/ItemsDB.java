package com.james;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemsDB {
    private static final String DB_CONNECTION_URL = "jdbc:sqlite:items.sqlite";

    // SQL statements
    private static final String CREATE_ITEM_TABLE = "CREATE TABLE items (name TEXT, effect INTEGER )";
    private static final String CREATE_INVENTORY_TABLE = "CREATE TABLE inventory (name TEXT, effect INTEGER)";
    private static final String GET_ALL_ITEMS = "SELECT * FROM items";


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


        } catch (SQLException e) {

            if (e.getMessage().contains("(table items already exists)")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
        }

    }

    public void createInventory() {

        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(CREATE_INVENTORY_TABLE);

        } catch (SQLException e) {

            if (e.getMessage().contains("(table items already exists)")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
        }

    }

}