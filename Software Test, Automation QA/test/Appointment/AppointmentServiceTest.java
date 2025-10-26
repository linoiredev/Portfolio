package test.appointment;

import main.appointment.Appointment;
import main.appointment.AppointmentService;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

    @Test
    void testAddAndDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment a = new Appointment("1", new Date(System.currentTimeMillis() + 1000), "Consultation");

        service.addAppointment(a);
        assertEquals(a, service.getAppointment("1"));

        service.deleteAppointment("1");
        assertNull(service.getAppointment("1"));
    }

    @Test
    void testDuplicateID() {
        AppointmentService service = new AppointmentService();
        Appointment a1 = new Appointment("1", new Date(System.currentTimeMillis() + 1000), "Consultation");
        Appointment a2 = new Appointment("1", new Date(System.currentTimeMillis() + 2000), "Initial Meeting");

        service.addAppointment(a1);
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(a2));
    }
}
