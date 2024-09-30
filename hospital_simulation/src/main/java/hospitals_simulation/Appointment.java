package hospitals_simulation;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    
    public Appointment(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    public String toString() {
        return ("Patient " + patient.getAppointmentCode() + " : " + patient.getName()+ "has an appointment scheduled with "+ doctor.getName());
    }
}
