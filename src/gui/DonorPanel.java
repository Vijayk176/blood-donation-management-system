package gui;

import dao.DonorDAO;
import model.Donor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DonorPanel extends JPanel {

    private JTextField nameField, bloodField, contactField, dateField;
    private JTable table;
    private DefaultTableModel model;
    private DonorDAO donorDAO = new DonorDAO();

    public DonorPanel() {
        setLayout(new BorderLayout(10,10));
        setBackground(new Color(245,245,245));

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(5,2,10,10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add Donor"));
        formPanel.setBackground(new Color(245,245,245));

        nameField = new JTextField();
        bloodField = new JTextField();
        contactField = new JTextField();
        dateField = new JTextField("YYYY-MM-DD");

        formPanel.add(new JLabel("Name")); formPanel.add(nameField);
        formPanel.add(new JLabel("Blood Group")); formPanel.add(bloodField);
        formPanel.add(new JLabel("Contact")); formPanel.add(contactField);
        formPanel.add(new JLabel("Last Donation")); formPanel.add(dateField);

        JButton addBtn = new JButton("Add Donor");
        addBtn.setBackground(new Color(70,130,180));
        addBtn.setForeground(Color.WHITE);
        addBtn.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(new JLabel());
        formPanel.add(addBtn);

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

        loadDonors();

        addBtn.addActionListener(e -> {
            Donor d = new Donor(0, nameField.getText(), bloodField.getText(), contactField.getText(), dateField.getText());
            donorDAO.addDonor(d);
            JOptionPane.showMessageDialog(this, "Donor Added");
            loadDonors();
        });
    }

    private void loadDonors() {
        model.setRowCount(0);
        ArrayList<Donor> donors = donorDAO.getAllDonors();
        for(Donor d : donors) {
            model.addRow(new Object[]{d.getId(), d.getName(), d.getBloodGroup(), d.getContact()});
        }
    }
}
