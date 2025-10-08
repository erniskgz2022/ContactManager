package models;

import db.GenerateId;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private Long id;
    private String name;
    private String brand;
    private List<Contact> contacts = new ArrayList<Contact>();
    public Phone() {
    }
    public Phone(Long id, String name, String brand) {
        this.id = GenerateId.genPhoneId();
        this.name = name;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
