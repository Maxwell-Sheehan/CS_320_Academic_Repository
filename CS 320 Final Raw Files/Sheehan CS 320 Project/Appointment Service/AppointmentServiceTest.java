
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentServiceTest {

    //test that an appt object is valid and can be recieved
    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();

        //create a valid future appt
        Appointment appt = new Appointment("1", new Date(System.currentTimeMillis() + 10000), "Dental Checkup");

        //add an appt to service
        service.addAppointment(appt);

        //retreive and verify the appt matches
        assertEquals(appt, service.getAppointment("1"));
    }

    //test for adding a second appt with a duplicate ID throws an exception
    @Test
    public void testAddDuplicateAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appt1 = new Appointment("1", new Date(System.currentTimeMillis() + 10000), "A");
        Appointment appt2 = new Appointment("1", new Date(System.currentTimeMillis() + 20000), "B");
        service.addAppointment(appt1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appt2);
        });
    }

    //test that we can delete an appt successfully
    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appt = new Appointment("1", new Date(System.currentTimeMillis() + 10000), "Dental Checkup");
        service.addAppointment(appt);
        service.deleteAppointment("1");

        //tests that appt is null and can't be found after del
        assertNull(service.getAppointment("1"));
    }

    //test to make sure trying to delete an appt that doesn't exist throws an exception
    @Test
    public void testDeleteNonexistentAppointment() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("999");
        });
    }
}
