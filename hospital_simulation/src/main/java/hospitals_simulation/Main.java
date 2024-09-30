package hospitals_simulation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         /* Create a hospital */
         Hospital h = new Hospital("Public Care Center");

         /* Adding two cardiologists*/
         h.addDoctor("David", 43, "cardio");
         h.addDoctor("Linda", 31, "cardio");
 
         /* Adding two neurosurgeons*/
         h.addDoctor("Mike", 37, "neuro");
         h.addDoctor("Katherine", 50, "neuro");
 
         /* Adding two dietiants*/
         h.addDoctor("Bob", 29, "diet");
         h.addDoctor("Chris", 41, "diet");
 
         /* Printing all doctors*/
        //  h.printAllCardiologists();
        //  h.printAllNeurosurgeons();
        //  h.printAllDietitians();

        /* Storing list in local ArrayLists */
        List<Cardiologist> cList = h.getCardiologists();
        List<Neurosurgeon> nList = h.getNeurosurgeons();
        List<Dietitian> dList = h.getDietitians();

        /* Sending patient to first cardiologist*/
        h.sendPatient(cList.get(0));

        /* Trying sending another patient */
        h.sendPatient(cList.get(0));

        cList.get(0).setAvailability(true);
        h.sendPatient(cList.get(0));
    }
}