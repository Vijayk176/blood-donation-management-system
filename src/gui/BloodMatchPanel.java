package gui;

import dao.DonorDAO;
import model.Donor;
import service.BloodCompatibility;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BloodMatchPanel extends JPanel {

    private JTextField bloodField;
    private JTextArea resultArea;
    private DonorDAO donorDAO = new DonorDAO();

    public BloodMatchPanel() {
        setLayout(new BorderLayout(10,10));
        setBackground(new Color(245,245,245));

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10,10));
        inputPanel.setBackground(new Color(245,245,245));

        JLabel label = new JLabel("Recipient Blood Type:");
        label.setFont(new Font("Arial", Font.BOLD, 14));

        bloodField = new JTextField(10);
        JButton searchBtn = new JButton("Find Compatible Donors");
        searchBtn.setBackground(new Color(70,130,180));
        searchBtn.setForeground(Color.WHITE);

        inputPanel.add(label);
        inputPanel.add(bloodField);
        inputPanel.add(searchBtn);

        add(inputPanel, BorderLayout.NORTH);

        // Result Area
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(resultArea);
        add(scroll, BorderLayout.CENTER);

        // Button Action
        searchBtn.addActionListener(e -> findCompatibleDonors());
    }

    private void findCompatibleDonors() {
        String recipientBlood = bloodField.getText().trim();
        resultArea.setText("");

        if(recipientBlood.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a blood type");
            return;
        }

        ArrayList<Donor> donors = donorDAO.getAllDonors();
        List<String> compatible = BloodCompatibility.getCompatibleDonors(recipientBlood);

        for(Donor d : donors) {
            if(compatible.contains(d.getBloodGroup())) {
                resultArea.append(d.getName() + " - " + d.getBloodGroup() + "\n");
            }
        }
    }
}
