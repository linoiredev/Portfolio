package main.mainapp;

import main.contact.Contact;
import main.contact.ContactService;

public class Main {
    public static void main(String[] args) {
        ContactService service = new ContactService();
        Contact c = new Contact("222", "Jose", "Ramon", "4045559999", "333 Platano St");
        service.addContact(c);
        System.out.println("Added contact: " + c.getFirstName());
    }
}
