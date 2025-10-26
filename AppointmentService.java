package main.appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Duplicate ID");
        }
        appointments.put(appointment.getAppointmentID(), appointment);
    }

    public void deleteAppointment(String appointmentID) {
        appointments.remove(appointmentID);
    }

    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }
}