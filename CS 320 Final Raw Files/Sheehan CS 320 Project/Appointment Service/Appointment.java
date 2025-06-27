
import java.util.Date;

public class Appointment {

    //immutable fields
    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;

    //creates an appointment with id, date, and description
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past or null");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    //gets the appointment ID
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

}
