import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Patient implements Serializable {

    /**
     * data fields
     */
    private static int nbOfPatients = 0;
    private final String name;
    private final int ID;
    private final String phoneNumber;
    private final String address;
    private Date DateOfBirth;
    private final int sex;
    private final String doctor;
    private final String medicalCondition;

    /**
     prescriptionList: Array list of prescriptions for this patient.
     */
    ArrayList<Prescription> prescriptionList = new ArrayList<>();
    LocalDateTime appointment;

    /**
     patientList: Array list of all patients list.
     */
    static ArrayList<Patient> patientList = new ArrayList<>();

    public Patient(String name, String PhoneNumber, String Address,
                   Date DateOfBirth, int sex, String Doctor, String medicalCondition,
                   LocalDateTime appointment) {
        /**
        Patient constructor with 8 args
         */
        nbOfPatients++;
        this.ID = nbOfPatients;
        this.name = name;
        this.phoneNumber = PhoneNumber;
        this.address = Address;
        this.DateOfBirth = DateOfBirth;
        this.sex = sex;
        this.doctor = Doctor;
        this.medicalCondition = medicalCondition;
        this.appointment = appointment;
        patientList.add(this);
    }

    public static int getNbOfPatients() {
        return nbOfPatients;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public LocalDateTime getAppointment() {
        return appointment;
    }


    @Override
    public String toString() {

        /**
        String method that checks the gender of the patient
         = 0 --> female, other --> male
         */
        String gender;
        if (this.sex == 0) {
            gender = "Female";
        } else {
            gender = "Male";
        }
        return "\nPatient Name: " + getName() +
                "\nID: " + getID() +
                "\nPhoneNumber: " + getPhoneNumber() +
                "\nAddress: " + getAddress() +
                "\nDateOfBirth: " + getDateOfBirth() +
                "\nSex: " + gender +
                "\nDoctor: " + getDoctor() +
                "\nMedicalCondition: " + getMedicalCondition() +
                "\nAppointment: " + getAppointment();
    }

    public void addPrescription(Prescription P) {
        /**
        void method that adds prescription to the prescription list in the
         array list then print that this prescription is added
         */
        prescriptionList.add(P);
        System.out.println("Prescription Added");
    }
}
