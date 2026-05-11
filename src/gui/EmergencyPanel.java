package gui;

import service.EmergencyQueue;

import javax.swing.*;
import java.awt.*;

public class EmergencyPanel extends JPanel {

    private EmergencyQueue queue = new EmergencyQueue();
    private JTextArea area;
    private JTextField requestField;

    public EmergencyPanel() {
        setLayout(new BorderLayout(10,10));
        setBackground(new Color(245,245,245));

        // Input Panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10,10));
        topPanel.setBackground(new Color(245,245,245));

        requestField = new JTextField(20);
        JButton addBtn = new JButton("Add Request");
        addBtn.setBackground(new Color(70,130,180));
        addBtn.setForeground(Color.WHITE);

        JButton processBtn = new JButton("Process Request");
        processBtn.setBackground(new Color(220,20,60));
        processBtn.setForeground(Color.WHITE);

        topPanel.add(new JLabel("Emergency Request:"));
        topPanel.add(requestField);
        topPanel.add(addBtn);
        topPanel.add(processBtn);

        add(topPanel, BorderLayout.NORTH);

        // Result Area
        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(area);
        add(scroll, BorderLayout.CENTER);

        // Actions
        addBtn.addActionListener(e -> {
            String req = requestField.getText().trim();
            if(!req.isEmpty()) {
                queue.addRequest(req);
                area.append("Added: " + req + "\n");
                requestField.setText("");
            }
        });

        processBtn.addActionListener(e -> {
            String req = queue.processRequest();
            if(req != null)
                area.append("Processed: " + req + "\n");
            else
                area.append("No pending requests\n");
        });
    }
}
