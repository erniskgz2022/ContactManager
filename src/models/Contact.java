package models;

import db.GenerateId;

public class Contact {
    private String Name;
    private String phoneNumber;

    public Contact() {
    }
    public Contact( String name, String phoneNumber) {
        this.Name = name;
        this.phoneNumber = phoneNumber;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                ", Name='" + Name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
