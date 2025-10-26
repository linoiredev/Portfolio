package test.contact;

// Import the main Contact and ContactService classes
import main.contact.Contact;
import main.contact.ContactService;

// Import JUnit annotations and assertions
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    // Declare service and contact objects to be used in tests
    private ContactService service;
    private Contact contact;

    // This method runs before each test to set up the environment
    @BeforeEach
    void setUp() {
        // Initialize a new ContactService before each test
        service = new ContactService();

        // Create a new Contact with valid data
        contact = new Contact("111", "Juan", "Perez", "1112223333", "999 Puerto Plata Rd");

        // Add the contact to the service
        service.addContact(contact);
    }

    // Test adding a contact with a duplicate ID
    @Test
    void testAddDuplicateContact() {
        // Create another Contact with the same ID as the existing one
        Contact duplicate = new Contact("111", "Maria", "Lopez", "2223334444", "123 Calle Ocho");

        // Adding a duplicate should throw an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
    }

    // Test deleting an existing contact
    @Test
    void testDeleteContact() {
        // Delete the contact with ID "111"
        service.deleteContact("111");

        // After deletion, getContact should return null
        assertNull(service.getContact("111"));
    }

    // Test deleting a non-existent contact
    @Test
    void testDeleteNonExistentContact() {
        // Attempting to delete a contact that doesn't exist should throw an exception
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("222"));
    }

    // Test updating the first name of a contact
    @Test
    void testUpdateFirstName() {
        // Update the first name of the contact with ID "111"
        service.updateFirstName("111", "Maria");

        // Verify that the first name was updated correctly
        assertEquals("Maria", service.getContact("111").getFirstName());
    }

    // Test updating the last name of a contact
    @Test
    void testUpdateLastName() {
        service.updateLastName("111", "Lopez");
        assertEquals("Lopez", service.getContact("111").getLastName());
    }

    // Test updating the phone number of a contact
    @Test
    void testUpdatePhone() {
        service.updatePhone("111", "2223334444");
        assertEquals("2223334444", service.getContact("111").getPhone());
    }

    // Test updating the address of a contact
    @Test
    void testUpdateAddress() {
        service.updateAddress("111", "123 Calle Ocho");
        assertEquals("123 Calle Ocho", service.getContact("111").getAddress());
    }

    // Test updating a non-existent contact
    @Test
    void testUpdateNonExistentContact() {
        // Attempting to update a contact that doesn't exist should throw an exception
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("333", "Luis"));
    }
}
