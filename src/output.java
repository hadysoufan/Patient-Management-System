import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class output {


    public output() {
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(new FileOutputStream("PatientManagementSystem.dat"));
            for (int i = 0; i < Patient.patientList.size(); i++) {
                out.writeObject(Patient.patientList.get(i));
            }
            for (int i = 0; i < Prescription.ids.size(); i++) {
                out.writeObject(Prescription.ids.get(i));
            }
            for (int i = 0; i < Clinic.clinicList.size(); i++) {
                out.writeObject(Clinic.clinicList.get(i));
            }
            out.close();
        } catch (IOException ex) {
        }
    }
}
