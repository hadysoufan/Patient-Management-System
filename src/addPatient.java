import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addPatient extends JFrame {

    JLabel title, Cname, Pname, result;
    JTextField CnameTF, PnameTF;
    JButton back, ok;

    public addPatient() {
        Font f = new Font("", 10, 16);
        final Container cp = getContentPane();
        cp.setLayout(new GridLayout(5, 1));
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        title = new JLabel("Add a Patient to the Clinic");
        Cname = new JLabel("Write the name of the Clinic");
        Pname = new JLabel("Write the name of the Patient");
        result = new JLabel("");
        result.setVisible(false);
        CnameTF = new JTextField(10);
        PnameTF = new JTextField(10);
        ok = new JButton("OK");
        back = new JButton("Back");

        title.setFont(f);

        ok.setBackground(new Color(20, 160, 160));
        back.setBackground(new Color(0, 180, 160));
        back.setBackground(new Color(0, 160, 180));
        PnameTF.setBackground(new Color(225, 230, 230));
        CnameTF.setBackground(new Color(225, 230, 230));

        title.setForeground(new Color(20, 160, 160));
        ok.setForeground(Color.white);
        back.setForeground(Color.white);
        back.setForeground(Color.white);
        PnameTF.setForeground(new Color(0, 150, 160));
        Cname.setForeground(new Color(0, 180, 180));
        Pname.setForeground(new Color(10, 180, 190));
        CnameTF.setForeground(new Color(0, 150, 160));
        result.setForeground(new Color(20, 189, 170));

        p1.add(title);
        p2.add(Cname);
        p2.add(CnameTF);
        p3.add(Pname);
        p3.add(PnameTF);
        p3.add(ok);
        p4.add(back);
        p4.add(result);
        cp.add(p1);
        cp.add(p2);
        cp.add(p3);
        cp.add(p4);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIThird f = new GUIThird();
                dispose();
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int x = 0;
                for (int i = 0; i < Clinic.clinicList.size(); i++) {
                    if (CnameTF.getText().equals(Clinic.clinicList.get(i).getName())) {
                        x = 1;
                        for (int j = 0; j < Patient.patientList.size(); j++) {
                            if (Patient.patientList.get(j).getName().equals(PnameTF.getText())) {
                                x = 2;
                                Clinic.clinicList.get(i).addPatient(Patient.patientList.get(j));
                            }
                        }
                    }
                }
                if (x == 0) {
                    result.setVisible(true);
                    result.setText("Clinic not found!");
                }
                if (x == 1) {
                    result.setVisible(true);
                    result.setText("Patient not found!");
                }
            }
        });
        setTitle("Patient Management System");
        setSize(1550, 820);
        setVisible(true);
    }
}
