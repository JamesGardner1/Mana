package com.james;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemsDB {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:sqlite:ItemsDB.db";

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();

        String createItemsTable = "CREATE TABLE items (name TEXT, effect INTEGER)";
        statement.execute(createItemsTable);

        String createInventoryTable = "CREATE TABLE inventory (name TEXT)";
        statement.execute(createInventoryTable);

        String insertDataSql = "INSERT INTO items VALUES ('Sword', 5)";
        statement.execute(insertDataSql);

        insertDataSql = "INSERT INTO items VALUES ('Bow', 5)";
        statement.execute(insertDataSql);

        insertDataSql = "INSERT INTO items VALUES ('Orb', 5)";
        statement.execute(insertDataSql);

        insertDataSql = "INSERT INTO items VALUES ('Potion', 20)";
        statement.execute(insertDataSql);

        statement.close();

    }
}
