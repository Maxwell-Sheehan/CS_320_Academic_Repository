import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


//creates hash map to allow easier matinence of contact objects, add, delete, update etc
public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();


//create new contact as long as their id is unique
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }


    //deletes a contact by ID if it exists 
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new NoSuchElementException("contact not found");
        }
        contacts.remove(contactId);
    }

    private Contact getContact(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new NoSuchElementException("Contact not found");
        }
        return contact;
    }

    // methods ot update info


    public void updateFirstName(String contactId, String newFirstName) {
        getContact(contactId).setFirstName(newFirstName);
    }

    public void updateLastName(String contactId, String newLastName) {
        getContact(contactId).setLastName(newLastName);
    }

    public void updatePhone (String contactId, String newPhone) {
        getContact(contactId).setPhone(newPhone);
    }

    public void updateAddress (String contactId, String newAddress) {
        getContact(contactId).setAddress(newAddress);
    }
}