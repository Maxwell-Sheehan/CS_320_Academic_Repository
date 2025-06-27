
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date; //date object 

public class AppointmentTest {

    // test creation of a valid appointment 
    @Test
    public void testValidAppointment() {

        //this creates a future date 10 second aways
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appt = new Appointment("12345", futureDate, "Check-up");
        assertEquals("12345", appt.getAppointmentId());
        assertEquals("Check-up", appt.getDescription());
        assertEquals(futureDate, appt.getAppointmentDate());
    }

    // test taht a null ID throws an exception
    @Test
    public void testNullId() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Check-up");
        });
    }

    //test taht an ID longer then 10 characters throws an exception
    @Test
    public void testLongId() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Check-up");
        });

    }

    //test that a null date throws an exception
    @Test
    public void testNullDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Check-up");
        });
    }

    //test that a past date throws an exception
    @Test
    public void testPastDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 10000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate, "Check-up");
        });
    }

    //test taht a null description throws an exception
    @Test
    public void testNullDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);
        });
    }

    //test that a description longer then 50 char throws an exception
    @Test
    public void testLongDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        String longDesc = "This description is way too long to be valid in the system!";
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, longDesc);
        });
    }
}
