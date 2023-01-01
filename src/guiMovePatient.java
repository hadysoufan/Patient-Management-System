import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class guiMovePatient extends JFrame {

    JLabel nameOfClinicWithP, nameOfClinicMovedTo, patientName, image;
    JTextField clinicNameWithP, nbOfPatientsMoved, pName;
    ImageIcon img;

    public guiMovePatient() {

        final Container cp = getContentPane();
        cp.setLayout(new GridLayout(8, 1));

        JPanel p1 = new JPanel(new GridLayout(5, 2, 3, 3));
        JPanel p2 = new JPanel(new FlowLayout());


        img = new ImageIcon(new ImageIcon(getClass().getResource("assets/movePatient.gif")).getImage());
        image = new JLabel(img);

        nameOfClinicWithP = new JLabel("Move patient from:");
        nameOfClinicMovedTo = new JLabel("Move patient to:");
        patientName = new JLabel("Patient name:");

        clinicNameWithP = new JTextField("Enter Clinic Name", 2);
        nbOfPatientsMoved = new JTextField("Enter Clinic Name", 2);
        pName = new JTextField("Enter Patient Name", 2);

        JButton Done = new JButton("DONE");
        JButton back = new JButton("BACK");

//        JPanel p1 = new JPanel(new GridLayout(4, 2, 3, 3));

        p2.add(image);
        p1.add(nameOfClinicWithP);
        p1.add(clinicNameWithP);
        p1.add(nameOfClinicMovedTo);
        p1.add(nbOfPatientsMoved);
        p1.add(patientName);
        p1.add(pName);
        p1.add(back);
        p1.add(Done);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        cp.add(p2);
        cp.add(p1);
        nameOfClinicWithP.setForeground(new Color(0, 160, 160));
        nameOfClinicMovedTo.setForeground(new Color(0, 160, 180));
        patientName.setForeground(new Color(10, 160, 180));

        clinicNameWithP.setBackground(new Color(225, 230, 230));
        nbOfPatientsMoved.setBackground(new Color(225, 230, 230));
        pName.setBackground(new Color(225, 230, 230));
        clinicNameWithP.setForeground(new Color(0, 160, 160));
        nbOfPatientsMoved.setForeground(new Color(10, 160, 180));
        pName.setForeground(new Color(10, 180, 160));

        back.setBackground(new Color(0, 160, 180));
        back.setForeground(Color.white);
        Done.setBackground(new Color(0, 180, 160));
        Done.setForeground(Color.white);

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
        Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String PName = pName.getText();
                String oldc = clinicNameWithP.getText();
                String newc = nbOfPatientsMoved.getText();
                for (int i = 0; i < (Clinic.clinicList).size(); i++) {
                    if ((((Clinic.clinicList).get(i)).getName()).equals(oldc)) {
                        for (int l = 0; l < (Clinic.clinicList).size(); l++) {
                            if ((((Clinic.clinicList).get(l)).getName()).equals(newc)) {
                                for (int k = 0; k < (((Clinic.clinicList).get(i)).listOfPatients).size();
                                     k++) {
                                    if ((((((Clinic.clinicList).get(i)).listOfPatients).get(k)).getName())
                                            .equals(PName)) {
                                        ((Clinic.clinicList).get(i)).movePatient((((Clinic.clinicList)
                                                .get(i)).listOfPatients).get(k), ((Clinic.clinicList)
                                                .get(l)));
                                    }
                                }
                            } else {
                                System.out.println("clinic you want to move patient to doesn't exist");
                            }
                        }
                    } else {
                        System.out.println("clinic you want to move patient from doesn't exist");
                    }
                }
                GUIFirst f = new GUIFirst();
                dispose();
            }
        });

        clinicNameWithP.addFocusListener(new FocusListener() {
            /**
             creating a placeholder for the patient textField
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (clinicNameWithP.getText().equals("Enter Clinic Name")) {
                    clinicNameWithP.setText("");
                    clinicNameWithP.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        pName.addFocusListener(new FocusListener() {
            /**
             creating a placeholder for the patient textField
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (pName.getText().equals("Enter Patient Name")) {
                    pName.setText("");
                    pName.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        nbOfPatientsMoved.addFocusListener(new FocusListener() {
            /**
             creating a placeholder for the patient textField
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (nbOfPatientsMoved.getText().equals("Enter Clinic Name")) {
                    nbOfPatientsMoved.setText("");
                    nbOfPatientsMoved.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
    }

}
