package hospitals_simulation;

public class Cardiologist extends Person implements Doctor {
    private Boolean isAvailable;
    public Cardiologist(String name, int age) {
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
