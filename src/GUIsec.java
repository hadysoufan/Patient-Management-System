import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
public class GUIsec extends JFrame {


    /**
    data fields
     */
    JLabel page, patientL, image;
    JButton add, info, back;
    JTextField patient;
    ImageIcon img;

    public GUIsec() {

        /**
        constructor with all required methods
         */
        Font f = new Font("", 15, 20);

        final Container cp = getContentPane();
        cp.setLayout(new GridLayout(4, 1));

        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());

        /**
        implementing all data fields with the right code
         */
        img = new ImageIcon(new ImageIcon(getClass().getResource("assets/patients.png")).getImage());
        image = new JLabel(img);

        page = new JLabel("Search for a Patient", JLabel.CENTER);
        page.setFont(new Font("", Font.PLAIN, 30));

        add = new JButton("Add a patient");
        back = new JButton("Back");
        info = new JButton("Patient Information");


        patientL = new JLabel();
        patient = new JTextField("Enter Patient Name", 15);


        /**
        adding background color
         */
        add.setBackground(new Color(251, 234, 160));
        back.setBackground(new Color(0, 160, 180));
        info.setBackground(new Color(0, 160, 160));
        patient.setBackground(new Color(225, 230, 230));


        /**
        adding font color
         */
        page.setForeground(new Color(20, 160, 160));
        add.setForeground(Color.white);
        back.setForeground(Color.white);
        info.setForeground(Color.white);
        patient.setForeground(new Color(0, 160, 160));
        patientL.setForeground(new Color(20, 160, 160));


        /**
        adding all data fields to the panel
         */
        p1.add(image);
        p2.add(page);
        p3.add(patient);
        p3.add(info);
        p3.add(add);
        p3.add(back);
        p3.add(patientL);
        cp.add(p1);
        cp.add(p2);
        cp.add(p3);


        add.addActionListener(new ActionListener() {
            /**
            ActionListener that render the add patient panel
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                guiAddPatient f = new guiAddPatient();
                dispose();
            }
        });

        back.addActionListener(new ActionListener() {
            /**
            ActionListener that return back to the main panel
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIFirst f = new GUIFirst();
                dispose();
            }
        });


        patient.addFocusListener(new FocusListener() {
            /**
            creating a placeholder for the patient textField
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (patient.getText().equals("Enter Patient Name")) {
                    patient.setText("");
                    patient.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        info.addActionListener(new ActionListener() {
            /**
            ActionListener that display the info of the patient if valid,
             otherwise it displays patient not found,
             if the input was not characters, it throws an error
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                p3.add(patientL);
                int c = 0;
                try {
                    int patientNumber = Integer.parseInt(patient.getText());
                    patientL.setText("Please enter a valid Name !!!");
                } catch (NumberFormatException e) {
                    for (int i = 0; i < Patient.patientList.size(); i++) {
                        if (Patient.patientList.get(i).getName().equals(patient.getText())) {
                            patientL.setText(Patient.patientList.get(i).toString());
                            c++;
                        }

                    }
                    if (c == 0) {
                        patientL.setText("Patient not found!");
                    }
                }
            }
        });


        setTitle("Pure Health Clinic");
        setSize(1550, 820);
        setVisible(true);
    }


}
