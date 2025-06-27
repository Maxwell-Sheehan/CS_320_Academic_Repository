import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.NoSuchElementException;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setup() {
        service = new ContactService();
        service.addContact(new Contact("001", "John", "smith", "1234567890", "1234 Main St"));
    }

    @Test
    void testAddDuplicateContactId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> { 
            service.addContact(new Contact("001", "Jane", "Smith", "0987654321", "456 Elm St"));
        });
        assertTrue(exception.getMessage().contains("exists"));
    }

    @Test
    void testDeleteContact() {
        service.deleteContact("001");
        assertThrows(NoSuchElementException.class, () -> service.deleteContact("001"));
    }

    @Test
    void testUpdateFields() {
        service.updateFirstName("001", "Mike");
        assertEquals("Mike", service.getFirstName("001"));

        service.updatePhone("001", "9999999999");
        assertEquals("9999999999", service.getPhone("001"));
    }

    @Test
    void testInvalidPhoneUpdate() {
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("001", "1234"));
    }
    // Helper accessors for test verification
    public String getFirstName(String contactId) {
        return getContact(contactId).getFirstName();
    }

    public String getPhone(String contactId) {
        return getContact(contactId).getPhone();
    }

        
}