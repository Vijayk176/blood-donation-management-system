package model;

import java.util.LinkedList;

public class Donor {
    private int id;
    private String name;
    private String bloodGroup;
    private String contact;
    private String lastDonationDate;
    private LinkedList<String> donationHistory;

    public Donor(int id, String name, String bloodGroup, String contact, String lastDonationDate) {
        this.id = id;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.contact = contact;
        this.lastDonationDate = lastDonationDate;
        this.donationHistory = new LinkedList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getBloodGroup() { return bloodGroup; }
    public String getContact() { return contact; }
    public String getLastDonationDate() { return lastDonationDate; }

    public void addDonation(String record) {
        donationHistory.add(record);
    }

    public LinkedList<String> getDonationHistory() {
        return donationHistory;
    }
}
