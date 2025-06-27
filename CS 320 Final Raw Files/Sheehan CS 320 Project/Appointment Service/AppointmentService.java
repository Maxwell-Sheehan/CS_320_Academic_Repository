
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {


    //store appts by appointmentID as the key
    private Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }


    //deletes and appointment by appointmentID
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        appointments.remove(appointmentId);
    }

    //retrieves appointment by ID
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
