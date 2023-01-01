import java.io.Serializable;
import java.util.ArrayList;

public class Prescription implements Serializable {

    /**
     * data fields
     */
    private final int ID;
    private int patientID;
    private final String Date;
    private final String drugName;
    private final String drugType;
    private final String drugDuration;
    private final String drugAdvice;
    private static final int nbOfPrescription = 0;
    static ArrayList<Prescription> ids = new ArrayList<>();

    public Prescription(int ID, int patientID, String Date, String drugName,
                        String drugType, String drugDuration, String drugAdvice) {
        /**
         Prescription constructor with 7 args
         */
        this.ID = ID;
        this.patientID = patientID;
        this.Date = Date;
        this.drugName = drugName;
        this.drugType = drugType;
        this.drugDuration = drugDuration;
        this.drugAdvice = drugAdvice;
        ids.add(this);
        for (int i = 0; i < Patient.getNbOfPatients(); i++) {
            if (patientID == i) {
                Patient.patientList.get(i).prescriptionList.add(this);
            }
        }
    }

    /**
     * getters and setters
     */
    public int getID() {
        return ID;
    }

    public String showPrescription(int ID) {
        /**
         String method that returns all the details of the Prescription
         */
        return "Drug Name: " + ids.get(ID).drugName +
                "\nType: " + ids.get(ID).drugType +
                "\nDate: " + ids.get(ID).Date +
                "\nAdvice: " + ids.get(ID).drugAdvice +
                "\nduration" + ids.get(ID).drugDuration +
                "\n----------------------------------------";
    }

    public String toString(){
        return "Drug Name: " + ids.get(ID).drugName +
                "\nType: " + ids.get(ID).drugType +
                "\nDate: " + ids.get(ID).Date +
                "\nAdvice: " + ids.get(ID).drugAdvice +
                "\nduration" + ids.get(ID).drugDuration +
                "\n----------------------------------------";
    }
}
