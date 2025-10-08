import models.Contact;
import models.Phone;
import service.ContactService;
import service.Impl.ContactServiceImpl;
import service.Impl.PhoneServiceImpl;
import service.PhoneService;

public class Main {
    public static void main(String[] args) {
        PhoneService phoneService = new PhoneServiceImpl();
        ContactService contactService = new ContactServiceImpl();

        Phone p1 = new Phone( "Samsung Galaxy S23", "Samsung");
        Phone p2 = new Phone( "iPhone 15", "Apple");

        System.out.println(phoneService.addPhone(p1));
        System.out.println(phoneService.addPhone(p2));

        Contact c1 = new Contact( "Asel", "0550123456");
        Contact c2 = new Contact( "Ernis", "0700123456");
        Contact c3 = new Contact( "Beka", "0777123456");

        System.out.println(contactService.addContactToPhone(1, c1));
        System.out.println(contactService.addContactToPhone(1, c2));
        System.out.println(contactService.addContactToPhone(2, c3));

        System.out.println("\nAll phones:");
        phoneService.getAllPhones().forEach(System.out::println);

        System.out.println("\nFind contact by name (Ernis):");
        System.out.println(contactService.findContactByName(1, "Ernis"));

        System.out.println("\nFind contact by phone number (0777123456):");
        System.out.println(contactService.findContactByPhoneNumber(2, "0777123456"));

        System.out.println("\nSorted contacts by name in phone 1:");
        contactService.sortContactsByName(1).forEach(System.out::println);

        System.out.println("\nUpdate phone name:");
        phoneService.updatePhoneNameById(1, "Samsung Galaxy S24");
        System.out.println(phoneService.getPhoneById(1));


        System.out.println("\nAll phones by brand 'Apple':");
        phoneService.getAllPhonesByBrand("Apple").forEach(System.out::println);


        System.out.println("\nDelete contact 'Asel' from phone 1:");
        contactService.deleteContactByNameFromPhone(1, "Asel");
        contactService.sortContactsByName(1).forEach(System.out::println);


        System.out.println("\nDelete phone by ID 2:");
        phoneService.deletePhoneById(2);
        phoneService.getAllPhones().forEach(System.out::println);
    }
}