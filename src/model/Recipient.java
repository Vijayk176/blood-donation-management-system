package model;

public class Recipient {
    private int id;
    private String name;
    private String requiredBlood;
    private String contact;

    public Recipient(int id, String name, String requiredBlood, String contact) {
        this.id = id;
        this.name = name;
        this.requiredBlood = requiredBlood;
        this.contact = contact;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRequiredBlood() { return requiredBlood; }
    public String getContact() { return contact; }
}
