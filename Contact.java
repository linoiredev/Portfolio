package main.contact;

public class Contact {

    // Unique identifier for the contact (cannot be updated after creation)
    private final String contactId;

    // Contact fields that can be updated
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor to create a new Contact
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate the contact ID: must not be null and max length 10
        if(contactId == null || contactId.length() > 10)
            throw new IllegalArgumentException("Invalid contact ID");

        // Validate first name: must not be null and max length 10
        if(firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");

        // Validate last name: must not be null and max length 10
        if(lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");

        // Validate phone: must not be null and exactly 10 digits
        if(phone == null || !phone.matches("\\d{10}"))
            throw new IllegalArgumentException("Invalid phone number");

        // Validate address: must not be null and max length 30
        if(address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");

        // Assign validated values to fields
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter for contact ID (read-only)
    public String getContactId() {
        return contactId;
    }

    // Getter and setter for first name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        this.firstName = firstName;
    }

    // Getter and setter for last name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        this.lastName = lastName;
    }

    // Getter and setter for phone number
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(phone == null || !phone.matches("\\d{10}"))
            throw new IllegalArgumentException("Invalid phone number");
        this.phone = phone;
    }

    // Getter and setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");
        this.address = address;
    }
}