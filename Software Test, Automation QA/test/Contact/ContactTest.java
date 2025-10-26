package test.contact;

// Import the Contact class from the main source code
import main.contact.Contact;

// Import JUnit annotations and assertions
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    // Test that a Contact object is correctly created with valid inputs
    @Test
    void testValidContactCreation() {
        // Create a new Contact object with valid data
        Contact contact = new Contact("111", "Juan", "Perez", "1234567890", "999 Puerto Plata Rd");

        // Verify that all fields are set correctly
        assertEquals("111", contact.getContactId());   // ID should match
        assertEquals("Juan", contact.getFirstName());  // First name should match
        assertEquals("Perez", contact.getLastName());  // Last name should match
        assertEquals("1234567890", contact.getPhone());// Phone number should match
        assertEquals("999 Puerto Plata Rd", contact.getAddress()); // Address should match
    }

    // Test that invalid Contact IDs throw exceptions
    @Test
    void testInvalidContactId() {
        // ID cannot be null
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "Maria", "Lopez", "1112223333", "123 Calle Ocho"));

        // ID cannot exceed the allowed length (assume 10 characters max)
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "Maria", "Lopez", "1112223333", "123 Calle Ocho"));
    }

    // Test that invalid first names throw exceptions
    @Test
    void testInvalidFirstName() {
        // First name cannot be null
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("222", null, "Gomez", "1112223333", "456 Avenida Libertad"));

        // First name cannot exceed the maximum length (assume 10-20 chars max)
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("222", "ThisNameIsTooLong", "Gomez", "1112223333", "456 Avenida Libertad"));
    }

    // Test that invalid phone numbers throw exceptions
    @Test
    void testInvalidPhone() {
        // Phone number cannot be too short
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("333", "Carlos", "Ramirez", "123", "789 Calle Luna"));

        // Phone number cannot be null
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("333", "Carlos", "Ramirez", null, "789 Calle Luna"));
    }

    // Test that invalid addresses throw exceptions
    @Test
    void testInvalidAddress() {
        // Address cannot be null
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("444", "Luis", "Sanchez", "1112223333", null));

        // Address cannot exceed the maximum allowed length
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("444", "Luis", "Sanchez", "1112223333", "This address is way too long for the limit"));
    }
}
