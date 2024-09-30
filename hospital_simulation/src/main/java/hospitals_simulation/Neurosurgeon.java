package hospitals_simulation;

public class Neurosurgeon extends Person implements Doctor {
    private Boolean isAvailable;

    public Neurosurgeon(String name, int age) {
        super(name, age);
        this.isAvailable= true;
    }

    public String toString() {
        return (this.getClass().getSimpleName()+super.toString()+"\n\tAvailable:"+isAvailable);
    }

    public String getName() {
        return this.getName();
    }

    public void setAvailability(boolean status)
    {
        isAvailable = status;
    }

    public Boolean getAvailability() {
        return isAvailable;
    }

}
