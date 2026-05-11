package main;

import dao.DBConnection;
import gui.LoginFrame;

public class Main {
    public static void main(String[] args) {

        // Create tables if not exist
        try (var con = DBConnection.getConnection(); var stmt = con.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS donors (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, " +
                    "blood_group TEXT, " +
                    "contact TEXT, " +
                    "last_donation TEXT)");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS recipients (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, " +
                    "required_blood TEXT, " +
                    "contact TEXT)");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS donations (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "donor_id INTEGER, " +
                    "recipient_id INTEGER, " +
                    "donation_date TEXT)");

        } catch (Exception e) {
            e.printStackTrace();
        }
        new LoginFrame();
    }
}
