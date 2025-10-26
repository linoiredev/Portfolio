package test.appointment;

import main.appointment.Appointment;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    @Test
    void testValidAppointment() {
        Appointment a = new Appointment("777", new Date(System.currentTimeMillis() + 1000), "Consultation");
        assertEquals("777", a.getAppointmentID());
    }

    @Test
    void testInvalidID() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment(null, new Date(System.currentTimeMillis() + 1000), "Desc")
        );
    }

    @Test
    void testPastDate() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("777", new Date(System.currentTimeMillis() - 10000), "Desc")
        );
    }
}
