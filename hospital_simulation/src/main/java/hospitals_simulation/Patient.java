package hospitals_simulation;

public class Patient extends Person{
    
    private static int appointmentCode = 0;



    public Patient(String name, int age) {
        super(name, age);
        appointmentCode++;
    }

    public String toString() {
        return (this.getClass().getSimpleName() + super.toString());
    }

    public int getCode() {
        return appointmentCode;
    }

    public int getAge() {
        return this.getAge();
    }

    public String getName() {
        return this.getName();
    }

    public int getAppointmentCode() {
        return appointmentCode;
    }
    
}
