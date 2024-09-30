package hospitals_simulation;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String name;
    private List<Cardiologist> cardiologists;
    private List<Neurosurgeon> neurosurgeons;
    private List<Dietitian> dietitians;
    private List<Patient> patients;
    private List<Appointment> appointments;
    

    public Hospital(String name) {
        this.name = name;
        cardiologists = new ArrayList<Cardiologist>();
        neurosurgeons = new ArrayList<Neurosurgeon>();
        dietitians = new ArrayList<Dietitian>();
        patients = new ArrayList<Patient>();
        appointments = new ArrayList<Appointment>();
    }

    public String getName() {
        return name;
    }

    public List<Cardiologist> getCardiologists() {
        return cardiologists;
    }

    public List<Neurosurgeon> getNeurosurgeons() {
        return neurosurgeons;
    }

    public List<Dietitian> getDietitians() {
        return dietitians;
    }

    public void addDoctor(String name, int age, String dep) {
        if (dep == "cardio") {
            cardiologists.add(new Cardiologist(name, age));
        } else if (dep == "neuro") {
            neurosurgeons.add(new Neurosurgeon(name, age));
        } else if (dep == "diet") {
            dietitians.add(new Dietitian(name, age));
        } else {
            throw new IllegalArgumentException("Invalid department: " + dep);
        }

    }

    public void printDoctor(Doctor d) {
        System.out.println(d);
    }

    public void bookAppointment(String patientMame, int patientAge, String doctorType) {
        Patient p = new Patient(patientMame, patientAge);
        Appointment a;
        if (doctorType == "cardio") {
            int randomNumber = (int)(Math.random() * cardiologists.size());
            Cardiologist c = cardiologists.get(randomNumber);
            patients.add(p);
            a = new Appointment(p, c);
            appointments.add(a);
        } else if (doctorType == "neuro") {
            int randomNumber = (int)(Math.random() * neurosurgeons.size());
            Neurosurgeon c = neurosurgeons.get(randomNumber);
            patients.add(p);
            a = new Appointment(p, c);
            appointments.add(a);
        } else if (doctorType == "diet") {
            int randomNumber = (int)(Math.random() * dietitians.size());
            Dietitian c = dietitians.get(randomNumber);
            patients.add(p);
            a = new Appointment(p, c);
            appointments.add(a);
        } else {
            throw new IllegalArgumentException("Invalid department: " + doctorType);
        }
        System.err.println(a);
    }

    public void printAllCardiologists() {
        cardiologists.forEach(x -> System.out.println(x));
    }

    public void printAllNeurosurgeons() {
        neurosurgeons.forEach(x -> System.out.println(x));
    }

    public void printAllDietitians() {
        dietitians.forEach(x -> System.out.println(x));
    }

    /* Send in a patient - overloaded methods */
    public void sendPatient(Cardiologist c)
    {
        if(c.getAvailability() == true)
        {
            System.out.println("It's your turn, please go inside.");
            c.setAvailability(false);
        }
        else
        {
            System.out.println("Sorry for the delay. Please wait for your turn.");
        }
    }

    public void sendPatient(Neurosurgeon ne)
    {
        if(ne.getAvailability() == true)
        {
            System.out.println("It's your turn, please go inside.");
            ne.setAvailability(false);
        }
        else
        {
            System.out.println("Sorry for the delay. Please wait for your turn.");
        }
    }

    public void sendPatient(Dietitian d)
    {
        if(d.getAvailability() == true)
        {
            System.out.println("It's your turn, please go inside.");
            d.setAvailability(false);
        }
        else
        {
            System.out.println("Sorry for the delay. Please wait for your turn.");
        }
    }
}
