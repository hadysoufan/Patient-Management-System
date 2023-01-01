import java.util.ArrayList;

public class Clinic {

    /**
    data fields
     */
    private final String name;
    private final int maxNumberOfPatients;

     /**
     listOfPatients: Array list of patients.
     */
    ArrayList<Patient> listOfPatients = new ArrayList<>();

    /**
     clinicList: Array list of all patients in the clinic.
     */
    static ArrayList<Clinic> clinicList = new ArrayList<>();

    public Clinic(String name, int maxNumberOfPatients) {
        /**
        Clinic constructor with 2 args
         */
        this.name = name;
        this.maxNumberOfPatients = maxNumberOfPatients;
        listOfPatients.sort(new sort());
        clinicList.add(this);
    }

    /**
    getters and setters
     */
    public String getName() {

        return name;
    }

    public int getMaxNumberOfPatients() {
        return maxNumberOfPatients;
    }

    public void addPatient(Patient p) {
        /**
        void method that takes an object p from Patient class as args
         It will check first if the array list size of listOfPatients is equal
         to the maxNumberOfPatients, then will check if arraylist already contains this patient,
         it will print Patient already exists, else, this object p will be added to the
         arraylist listOfPatients.

         Otherwise, it will print that number of patients should not be greater than
         maxNumberOfPatients
         */

        if (listOfPatients.size() <= this.maxNumberOfPatients) {
            if (listOfPatients.contains(p)) {
                System.out.println("Patient already exists!");
            } else {
                listOfPatients.add(p);
            }
        } else {
            System.out.printf("The number of patients in this clinic should not exceed %s patients."
            ,this.maxNumberOfPatients);
        }
        listOfPatients.sort(new sort());
    }

    public void removePatient(Patient p) {
        /**
        void method that removes patient from the listOfPatients it exists,
         otherwise it will print patient doesn't exist!
         */
        if (listOfPatients.contains(p)) {
            listOfPatients.remove(p);
        } else {
            System.out.println("Patient doesn't exist!");
        }
    }

    public void movePatient(Patient p, Clinic c) {
        /**
        void method that move a patient from a clinic to another if exists,
         otherwise it will print patient doesn't exist!
         */
        if (listOfPatients.contains(p)) {
            listOfPatients.remove(p);
            c.listOfPatients.add(p);
        } else {
            System.out.println("Patient doesn't exist!");
        }
    }

    public ArrayList<Patient> getListOfPatient() {
        return listOfPatients;
    }

    public ArrayList<Patient> getListOfPatientsByMedicalCondition(String s) {
        ArrayList<Patient> patientsByMedicalConditions = new ArrayList<>();
        for (Patient listOfPatient : listOfPatients) {
            if ((listOfPatient.getMedicalCondition()).equalsIgnoreCase(s)) {
                patientsByMedicalConditions.add(listOfPatient);
            }
        }
        return patientsByMedicalConditions;
    }

    public String getPatientHistory(Patient patient) {
        StringBuilder details = new StringBuilder(patient.toString() + ",Clinic name: " + this.name);
        for (int i = 0; i < patient.prescriptionList.size(); i++) {
            details.append(", ").append(((patient.prescriptionList).get(i)).showPrescription(i));
        }
        return details.toString();
    }

    public String toString(){
        return "Name: " + getName() +
                "\nMax number Of Patients: " + getMaxNumberOfPatients() +
                "\n----------------------------------------";
    }


}
