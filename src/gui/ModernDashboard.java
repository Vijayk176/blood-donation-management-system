package gui;

import javax.swing.*;
import java.awt.*;

public class ModernDashboard extends JFrame {

    public ModernDashboard() {
        setTitle("Blood Donation Management System");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Header
        JLabel header = new JLabel("Blood Donation Management System", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 26));
        header.setOpaque(true);
        header.setBackground(new Color(220, 20, 60)); // crimson
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(900, 60));
        add(header, BorderLayout.NORTH);

        // Tabs for modules
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(new Font("Arial", Font.PLAIN, 16));
        tabs.setForeground(new Color(50,50,50));

        tabs.addTab("Donors", new DonorPanel());
        tabs.addTab("Recipients", new RecipientPanel());
        tabs.addTab("Blood Matching", new BloodMatchPanel());
        tabs.addTab("Emergency Requests", new EmergencyPanel());

        add(tabs, BorderLayout.CENTER);

        setVisible(true);
    }
}
