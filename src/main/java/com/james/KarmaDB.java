package com.james;

import java.sql.*;
import java.util.Vector;

public class KarmaDB {

    String DB_CONNECTION_URL = "jdbc:sqlite:karma.sqlite";

    // SQL statements
    String CREATE_KARMA_TABLE = "CREATE TABLE karma (event INTEGER PRIMARY KEY , name TEXT, description TEXT, face TEXT)";
    String GET_KARMA = "SELECT * FROM karma";
    private static final String ADD_EVENT = "INSERT INTO karma (name, description, face) VALUES (?, ?, ?) ";



    KarmaDB() {
        createTable();
    }

    public void createTable() {

        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(CREATE_KARMA_TABLE);

        } catch (SQLException e) {

            if (e.getMessage().contains("(table karma already exists)")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
        }
    }

    public void addKarma(String name, String description, String face) {
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_EVENT)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, face);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    Vector getColumnNames() {

        Vector<String> colNames = new Vector<String>();

        colNames.add("Event");
        colNames.add("Name");
        colNames.add("Description");
        colNames.add("Face");

        return colNames;
    }


    Vector<Vector> getKarma() {

        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(GET_KARMA);

            Vector<Vector> vectors = new Vector<>();

            int id;
            String name, description, face;

            while (rs.next()) {

                id = rs.getInt("event");
                name = rs.getString("name");
                description = rs.getString("description");
                face = rs.getString("face");

                Vector v = new Vector();
                v.add(id); v.add(name); v.add(description);v.add(face);

                vectors.add(v);
            }

            return vectors;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
