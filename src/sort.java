import java.util.Comparator;

public class sort implements Comparator<Patient> {

    @Override
    public int compare(Patient a, Patient b) {
        return a.appointment.compareTo(b.appointment);
    }
}