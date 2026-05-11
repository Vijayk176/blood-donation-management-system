package gui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Blood Donation Management System - Login");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Background panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(70, 130, 180)); // steel blue
        mainPanel.setLayout(new BorderLayout());

        // Header
        JLabel header = new JLabel("Welcome to Blood Bank", SwingConstants.CENTER);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        mainPanel.add(header, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 15));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(new Color(70, 130, 180));
        loginBtn.setForeground(Color.WHITE);

        formPanel.add(userLabel);
        formPanel.add(userField);
        formPanel.add(passLabel);
        formPanel.add(passField);
        formPanel.add(new JLabel()); // empty
        formPanel.add(loginBtn);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        add(mainPanel);

        // Action listener
        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if(user.equals("admin") && pass.equals("admin")) {
                dispose();
                new ModernDashboard();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
