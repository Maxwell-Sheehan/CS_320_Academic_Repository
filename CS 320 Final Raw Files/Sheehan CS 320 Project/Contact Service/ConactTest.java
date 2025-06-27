import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact contact = new Contact ("123", "John", "Smith", "1234567890", "123 Main St");
        assertEquals("123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());

    }

    @Test

    // test for a valid contact id
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Smith", "1234567890", "123 Main St");
        });


        //we use a contact id with more then 10 cahr here to test if it will allow an invalid amount
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("23456789011", "John", "Smith", "1234567890", "123 Main St");
        });
    }

    @Test

    //check for a null first name
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Smith", "1234567890", "123 Main St");
        });


        //checks if the first name is too long
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "FirstnameTooLong", "Smith", "1234567890", "123 Main St");
        });
    }

    @Test

    //checks if phone number to short
    void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", "123", "123 Main St");
        });


        //checks if null phone number entry
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", null, "123 Main St");
        });
    }

    @Test
    void testSettersValidation() {
        Contact contact = new Contact("123", "John", "Smith", "1234567890", "123 Main St");

        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());

        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());


        
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("abc")); // invalid phone
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null)); // null address
    }
}


