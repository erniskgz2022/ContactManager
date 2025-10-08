package service.Impl;

import db.Database;
import models.Phone;
import service.PhoneService;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneServiceImpl implements PhoneService {
    @Override
    public String addPhone(Phone phone) {
        Database.phones.add(phone);
        return "Phone successfully added: " + phone.getName();
    }

    @Override
    public Phone getPhoneById(int phoneId) {
        return Database.phones
                .stream()
                .filter(p -> p.getId() == phoneId)
                .findFirst()
                .orElse(null);

    }

    @Override
    public Phone updatePhoneNameById(int phoneId, String newName) {
        Phone phone = Database.phones
                .stream()
                .filter(p -> p.getId() == phoneId)
                .findFirst()
                .orElse(null);
        if (phone != null) {
            phone.setName(newName);
        }
        return phone;
    }

    @Override
    public List<Phone> getAllPhones() {
        return Database.phones
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        return Database.phones
                .stream()
                .filter(p -> p.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePhoneById(int phoneId) {
        Database.phones
                .removeIf(p -> p.getId() == phoneId);
    }
}
