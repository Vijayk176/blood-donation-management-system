package dao;

import model.Donor;
import java.sql.*;
import java.util.ArrayList;

public class DonorDAO {

    // Add a new donor
    public void addDonor(Donor donor) {
        String sql = "INSERT INTO donors(name, blood_group, contact, last_donation) VALUES(?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, donor.getName());
            ps.setString(2, donor.getBloodGroup());
            ps.setString(3, donor.getContact());
            ps.setString(4, donor.getLastDonationDate());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all donors
    public ArrayList<Donor> getAllDonors() {
        ArrayList<Donor> list = new ArrayList<>();
        String sql = "SELECT * FROM donors";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Donor d = new Donor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("blood_group"),
                        rs.getString("contact"),
                        rs.getString("last_donation")
                );
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Delete a donor by ID
    public void deleteDonor(int id) {
        String sql = "DELETE FROM donors WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
