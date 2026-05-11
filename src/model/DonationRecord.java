package model;

import java.time.LocalDate;

public class DonationRecord {
    private int donorId;
    private int recipientId;
    private LocalDate donationDate;

    public DonationRecord(int donorId, int recipientId, LocalDate donationDate) {
        this.donorId = donorId;
        this.recipientId = recipientId;
        this.donationDate = donationDate;
    }

    public int getDonorId() { return donorId; }
    public int getRecipientId() { return recipientId; }
    public LocalDate getDonationDate() { return donationDate; }
}
