package service.Impl;

import db.Database;
import models.Contact;
import models.Phone;
import service.ContactService;
import service.PhoneService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService {
    @Override
    public String addContactToPhone(int phoneId, Contact contact) {
        Phone phone = Database.phones
                .stream()
                .filter(p -> p.getId() == phoneId)
                .findFirst()
                .orElse(null);

        if (phone != null) {
            phone.getContacts().add(contact);
            return "Contact added to phone: " + phone.getName();
        }
        return "Phone not found!";


}

    @Override
    public Contact findContactByName(int phoneId, String contactName) {
        return Database.phones
                .stream()
                .filter(p -> p.getId() == phoneId)
                .flatMap(p -> p.getContacts().stream())
                .filter(c -> c.getName().equalsIgnoreCase(contactName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Contact findContactByPhoneNumber(int phoneId, String phoneNumber) {
        return Database.phones
                .stream()
                .filter(p -> p.getId() == phoneId)
                .flatMap(p -> p.getContacts().stream())
                .filter(c -> c.getPhoneNumber().equals(phoneNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Contact> sortContactsByName(int phoneId) {
        return Database.phones
                .stream()
                .filter(p -> p.getId() == phoneId)
                .flatMap(p -> p.getContacts().stream())
                .sorted(Comparator.comparing(Contact::getName))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteContactByNameFromPhone(int phoneId, String contactName) {
        Database.phones
                .stream()
                .filter(p -> p.getId() == phoneId)
                .findFirst()
                .ifPresent(phone ->
                        phone.getContacts()
                                .removeIf(c -> c.getName().equalsIgnoreCase(contactName))
                );
    }
}