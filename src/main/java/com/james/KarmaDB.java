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

    public void goodTraveler() {
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_EVENT)) {

            preparedStatement.setString(1, "Helped Traveler");
            preparedStatement.setString(2, "Helped Traveler from under rock");
            preparedStatement.setString(3, "Good");

            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            if (e.getMessage().contains("(error)")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
        }
    }



    public void badTraveler() {
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("INSERT INTO karma (name, description, face) VALUES ('Robbed Traveler', 'Robbed Traveler Stuck Under Boulder','Bad')");

        } catch (SQLException e) {

            if (e.getMessage().contains("(error)")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
        }
    }

    public void goodLion() {
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("INSERT INTO karma (name, description, face) VALUES ('Saved Druid', 'Saved the Druids life in the forest','Good')");

        } catch (SQLException e) {

            if (e.getMessage().contains("(error)")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
        }
    }

    public void badLion() {
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("INSERT INTO karma (name, description, face) VALUES ('Killed Druid', 'Killed Injured Druid in the forest','Bad')");

        } catch (SQLException e) {

            if (e.getMessage().contains("(error)")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
        }
    }

    public void goodFisherman() {
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("INSERT INTO karma (name, description, face) VALUES ('Helped Fisherman', 'Helped the fisherman against the Bandit','Good')");

        } catch (SQLException e) {

            if (e.getMessage().contains("(error)")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
        }
    }

    public void badFisherman() {
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("INSERT INTO karma (name, description, face) VALUES ('Helped Bandit', 'Helped the bandit rob the fisherman','Bad')");

        } catch (SQLException e) {

            if (e.getMessage().contains("(error)")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
        }
    }

    public void goodWizard() {
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("INSERT INTO karma (name, description, face) VALUES ('Spared Wizard', 'Spared the Wizards life','Good')");

        } catch (SQLException e) {

            if (e.getMessage().contains("(error)")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
        }
    }

    public void badWizard() {
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("INSERT INTO karma (name, description, face) VALUES ('Killed Wizard', 'Took the Wizards Life','Good')");

        } catch (SQLException e) {

            if (e.getMessage().contains("(error)")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
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
