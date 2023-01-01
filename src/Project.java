import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Project {

    public static void main(String[] args) {

        System.out.println("Welcome to Pure Health Condition");

        /**
        initializing 3 array lists for 3 different classes
         */
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Clinic> clinics = new ArrayList<>();
        ArrayList<Prescription> prescriptions = new ArrayList<>();


        /**
         adding to the Clinic List 3 indexes that are instantiated to the Patient CLass
         */

        patients.add(new Patient("Hadi", "76740521", "Chouf", new Date(1998, 9, 13),
                0, "Julia", "Sick", LocalDateTime.of(2020, 5, 9, 8, 50)));

        patients.add(new Patient("Melia", "99555666", "Beirut", new Date(2003, 8, 19),
                0, "Sam", "HeadAce", LocalDateTime.of(2009, 4, 17, 11, 30)));

        patients.add(new Patient("Zayn", "90909090", "Tripoli", new Date(1999, 3, 8),
                0, "Alex", "Cancer", LocalDateTime.of(2019, 4, 5, 3, 10)));

        /**
        adding to the Clinic List 3 indexes that are instantiated to the Clinic CLass
         */
        clinics.add(new Clinic("Clinic One", 5));
        clinics.add(new Clinic("Clinic Two", 7));
        clinics.add(new Clinic("Clinic Three", 7));


        /**
         adding to the Clinic List 3 indexes that are instantiated to the Prescription CLass
         */
        prescriptions.add(new Prescription(3, 1, "2019,5,28", "drug1", "drugtype1",
                "duration of d1", "advice of d1"));

        prescriptions.add(new Prescription(2, 3, "2000,11,8", "drug2", "drugtype2",
                "duration of d2", "advice of d2"));


        /**
         try catch block that iterates every index in the ArrayList of Patient and
         write the data into a file called patient.dat
         */
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("patient.dat"))) {

            for (Patient p : patients) {
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         try catch block that iterates every index in the ArrayList of Clinic and
         write the data into a file called clinic.dat
         */
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("clinic.dat"))) {

            for (Clinic c : clinics) {
                bw.write(c.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         try catch block that iterates every index in the ArrayList of Prescription and
         write the data into a file called prescription.dat
         */
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("prescription.dat"))) {

            for (Prescription pre : prescriptions) {
                bw.write(pre.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        GUIFirst a = new GUIFirst();
    }
}
