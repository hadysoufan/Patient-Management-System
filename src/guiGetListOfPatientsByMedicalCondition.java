import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class guiGetListOfPatientsByMedicalCondition extends JFrame {

    JLabel NameofClinic, medicalcondition, list, listt;
    JTextField Clinicname, medcond;

    public guiGetListOfPatientsByMedicalCondition() {
        NameofClinic = new JLabel("Name of clinic:");
        medicalcondition = new JLabel("Medical condition:");
        list = new JLabel("list: ");
        listt = new JLabel();

        Clinicname = new JTextField(2);
        medcond = new JTextField(2);

        JButton ok = new JButton("OK");
        JButton back = new JButton("BACK");

        JPanel p1 = new JPanel(new GridLayout(4, 2, 3, 3));
        p1.add(NameofClinic);
        p1.add(Clinicname);
        p1.add(medicalcondition);
        p1.add(medcond);
        p1.add(list);
        p1.add(listt);
        p1.add(back);
        p1.add(ok);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(p1);

        NameofClinic.setForeground(new Color(0, 160, 160));
        medicalcondition.setForeground(new Color(0, 160, 180));
        list.setForeground(new Color(10, 160, 180));
        listt.setForeground(new Color(10, 180, 180));

        Clinicname.setBackground(new Color(225, 230, 230));
        medcond.setBackground(new Color(225, 230, 230));
        Clinicname.setForeground(new Color(0, 160, 160));
        medcond.setForeground(new Color(20, 160, 180));

        back.setBackground(new Color(0, 160, 180));
        back.setForeground(Color.white);
        ok.setBackground(new Color(0, 180, 160));
        ok.setForeground(Color.white);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pure Health Clinic");
        setSize(1550, 820);
        setVisible(true);
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
                ArrayList<Patient> listb = new ArrayList<>();
                String cname = Clinicname.getText();
                String mc = medcond.getText();
                String soflist = "";
                for (int i = 0; i < (Clinic.clinicList).size(); i++) {
                    if ((((Clinic.clinicList).get(i)).getName()).equals(cname)) {
                        listb = ((Clinic.clinicList).get(i))
                                .getListOfPatientsByMedicalCondition(mc);
                    }
                }
                for (int i = 0; i < listb.size(); i++) {
                    soflist += (listb.get(i)).getName() + ", ";
                }
                listt.setText(soflist);
            }
        });
    }


}
