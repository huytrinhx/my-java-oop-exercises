package hospitals_simulation;

public class Dietitian extends Person implements Doctor {
    private Boolean isAvailable;
    public Dietitian(String name, int age) {
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
