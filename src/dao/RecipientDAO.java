package dao;

import model.Recipient;
import java.sql.*;
import java.util.ArrayList;

public class RecipientDAO {

    // Add a new recipient
    public void addRecipient(Recipient r) {
        String sql = "INSERT INTO recipients(name, required_blood, contact) VALUES(?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getName());
            ps.setString(2, r.getRequiredBlood());
            ps.setString(3, r.getContact());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all recipients
    public ArrayList<Recipient> getAllRecipients() {
        ArrayList<Recipient> list = new ArrayList<>();
        String sql = "SELECT * FROM recipients";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Recipient r = new Recipient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("required_blood"),
                        rs.getString("contact")
                );
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
