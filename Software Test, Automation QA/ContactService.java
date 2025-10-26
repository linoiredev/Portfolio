package main.contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Store all contacts in a HashMap where the key is the contact ID
    // and the value is the Contact object. This allows fast lookups by ID.
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact to the service
    public void addContact(Contact contact) {
        // Check if a contact with the same ID already exists
        if(contacts.containsKey(contact.getContactId()))
            throw new IllegalArgumentException("Contact ID already exists");

        // Add the contact to the map
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by its unique ID
    public void deleteContact(String contactId) {
        // If the contact does not exist, throw an exception
        if(!contacts.containsKey(contactId))
            throw new IllegalArgumentException("Contact not found");

        // Remove the contact from the map
        contacts.remove(contactId);
    }

    // Update the first name of a contact
    public void updateFirstName(String contactId, String firstName) {
        // Retrieve the contact by ID
        Contact contact = contacts.get(contactId);
        // If the contact does not exist, throw an exception
        if(contact == null) throw new IllegalArgumentException("Contact not found");
        // Update the first name
        contact.setFirstName(firstName);
    }

    // Update the last name of a contact
    public void updateLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);
        if(contact == null) throw new IllegalArgumentException("Contact not found");
        contact.setLastName(lastName);
    }

    // Update the phone number of a contact
    public void updatePhone(String contactId, String phone) {
        Contact contact = contacts.get(contactId);
        if(contact == null) throw new IllegalArgumentException("Contact not found");
        contact.setPhone(phone);
    }

    // Update the address of a contact
    public void updateAddress(String contactId, String address) {
        Contact contact = contacts.get(contactId);
        if(contact == null) throw new IllegalArgumentException("Contact not found");
        contact.setAddress(address);
    }

    // Get contact method for JUnit test
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

}

