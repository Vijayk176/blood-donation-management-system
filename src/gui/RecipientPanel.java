package gui;

import dao.RecipientDAO;
import model.Recipient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class RecipientPanel extends JPanel {

    private JTextField nameField, bloodField, contactField;
    private JTable table;
    private DefaultTableModel model;
    private RecipientDAO recipientDAO = new RecipientDAO();

    public RecipientPanel() {
        setLayout(new BorderLayout(10,10));
        setBackground(new Color(245,245,245));

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(4,2,10,10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add Recipient"));
        formPanel.setBackground(new Color(245,245,245));

        nameField = new JTextField();
        bloodField = new JTextField();
        contactField = new JTextField();

        formPanel.add(new JLabel("Name")); formPanel.add(nameField);
        formPanel.add(new JLabel("Required Blood")); formPanel.add(bloodField);
        formPanel.add(new JLabel("Contact")); formPanel.add(contactField);

        JButton addBtn = new JButton("Add Recipient");
        addBtn.setBackground(new Color(70,130,180));
        addBtn.setForeground(Color.WHITE);
        addBtn.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(new JLabel()); formPanel.add(addBtn);

        add(formPanel, BorderLayout.NORTH);

        // Table Panel
        model = new DefaultTableModel(new String[]{"ID","Name","Blood","Contact"},0);
        table = new JTable(model);
        table.getTableHeader().setBackground(new Color(70,130,180));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        loadRecipients();

        addBtn.addActionListener(e -> {
            Recipient r = new Recipient(0, nameField.getText(), bloodField.getText(), contactField.getText());
            recipientDAO.addRecipient(r);
            JOptionPane.showMessageDialog(this, "Recipient Added");
            loadRecipients();
        });
    }

    private void loadRecipients() {
        model.setRowCount(0);
        ArrayList<Recipient> list = recipientDAO.getAllRecipients();
        for(Recipient r : list) {
            model.addRow(new Object[]{r.getId(), r.getName(), r.getRequiredBlood(), r.getContact()});
        }
    }
}
