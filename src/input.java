import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class input {

    public input() {
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(new FileInputStream("C:\\Users\\USER\\Documents\\InelliJ projects\\OOPFinalProject\\patient.dat"));
            for (int i = 0; i < Patient.patientList.size(); i++) {
                System.out.println(Patient.patientList.get(i));
            }
            for (int i = 0; i < Prescription.ids.size(); i++) {
                System.out.println(Prescription.ids.get(i));
            }
            for (int i = 0; i < Clinic.clinicList.size(); i++) {
                System.out.println(Clinic.clinicList.get(i));
            }
            in.close();
        } catch (IOException ex) {
        }
    }
}
