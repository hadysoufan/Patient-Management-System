import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.Choice;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Date;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Objects;


public class guiAddPatient extends JFrame {


    /**
    data fields
     */

    String name;
    String phoNumber;
    String addr;
    Date dob;
    int sex;
    String docName;
    String medCondition;
    LocalDateTime appDate;
    JLabel NamePatient, PhoneNumber, Address, DateOfBirth, DoctorName, MedicalCondition, AppointmentDate, nothing;
    JTextField patientName, phoneNumber, address, dateOfBirth, doctorName, appointmentDate;
    JRadioButton jRadioButtonf;
    JRadioButton jRadioButton;
    JLabel page, image;
    Choice medicalCondition;
    ImageIcon img;

    public guiAddPatient() {

        /**
         constructor with all required methods
         */

        Font f = new Font("", 15, 20);

        final Container cp = getContentPane();
        cp.setLayout(new GridLayout());

        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p = new JPanel(new GridLayout(1,1));
        JPanel p2 = new JPanel(new GridLayout(3,8));

        /**
         implementing all data fields with the right code
         */

        img = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/addPatients.png"))).getImage());
        image = new JLabel(img);

        page = new JLabel("Create new Patient", JLabel.CENTER);
        page.setFont(new Font("", Font.PLAIN, 30));


        NamePatient = new JLabel("Patient Name");
        PhoneNumber = new JLabel("Phone Number");
        Address = new JLabel("Address");
        DateOfBirth = new JLabel("Date Of Birth");
        DoctorName = new JLabel("Doctor Name");
        MedicalCondition = new JLabel("Medical Condition");
        AppointmentDate = new JLabel("Appointment Date");
        nothing = new JLabel("");

        patientName = new JTextField(2);
        phoneNumber = new JTextField(2);
        address = new JTextField(2);
        dateOfBirth = new JTextField("dd/MM/yyyy", 2);
        doctorName = new JTextField(2);
        medicalCondition = new Choice();

        medicalCondition.add("Diabetes");
        medicalCondition.add("Asthma");
        medicalCondition.add("Cancer");
        medicalCondition.add("Heart disease");
        medicalCondition.add("Obesity");
        medicalCondition.add("Hypertension");
        medicalCondition.add("Teeth");
        medicalCondition.add("Infectious diseases");
        medicalCondition.add("Mental health conditions");
        medicalCondition.add("Corona");
        medicalCondition.add("H1N1");


        appointmentDate = new JTextField("yyyy,MM,dd,HH,mm", 2);

        JButton Done = new JButton("DONE");
        JButton back = new JButton("BACK");
        jRadioButtonf = new JRadioButton("female");
        jRadioButton = new JRadioButton("male");


        /**
         adding all data fields to the panel
         */
        p1.add(image);
        p.add(page);
        p2.add(NamePatient);
        p2.add(patientName);
        p2.add(PhoneNumber);
        p2.add(phoneNumber);
        p2.add(Address);
        p2.add(address);
        p2.add(DateOfBirth);
        p2.add(dateOfBirth);
        p2.add(DoctorName);
        p2.add(doctorName);
        p2.add(MedicalCondition);
        p2.add(medicalCondition);
        p2.add(AppointmentDate);
        p2.add(appointmentDate);
        p2.add(jRadioButtonf);
        p2.add(jRadioButton);
        p2.add(back);
        p2.add(Done);
        cp.add(p1);
        cp.add(p);
        cp.add(p2);


        /**
         adding font color
         */
        NamePatient.setForeground(new Color(20, 160, 180));
        PhoneNumber.setForeground(new Color(0, 160, 160));
        Address.setForeground(new Color(0, 160, 180));
        DateOfBirth.setForeground(new Color(10, 160, 160));
        DoctorName.setForeground(new Color(0, 160, 160));
        MedicalCondition.setForeground(new Color(0, 160, 160));
        AppointmentDate.setForeground(new Color(10, 170, 190));
        nothing.setForeground(new Color(0, 180, 150));
        back.setForeground(Color.white);
        Done.setForeground(Color.white);

        patientName.setForeground(new Color(20, 160, 180));
        phoneNumber.setForeground(new Color(0, 160, 160));
        address.setForeground(new Color(0, 160, 180));
        dateOfBirth.setForeground(new Color(0, 160, 180));
        doctorName.setForeground(new Color(10, 160, 160));
        medicalCondition.setForeground(new Color(0, 160, 160));
        appointmentDate.setForeground(new Color(0, 160, 160));
        jRadioButtonf.setForeground(new Color(10, 170, 190));
        jRadioButton.setForeground(new Color(0, 180, 150));

        patientName.setBackground(new Color(225, 230, 230));
        phoneNumber.setBackground(new Color(225, 230, 230));
        address.setBackground(new Color(225, 230, 230));
        dateOfBirth.setBackground(new Color(225, 230, 230));
        doctorName.setBackground(new Color(225, 230, 230));
        medicalCondition.setBackground(new Color(225, 230, 230));
        appointmentDate.setBackground(new Color(225, 230, 230));

        back.setBackground(new Color(0, 160, 180));
        Done.setBackground(new Color(251, 234, 160));

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(p1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Patient ");
        setSize(1550, 820);
        setVisible(true);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIsec f = new GUIsec();
                dispose();
            }
        });

        dateOfBirth.addFocusListener(new FocusListener() {
            /**
             creating a placeholder for the date of birth textField
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (dateOfBirth.getText().equals("dd/MM/yyyy")) {
                    dateOfBirth.setText("");
                    dateOfBirth.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        appointmentDate.addFocusListener(new FocusListener() {
            /**
             creating a placeholder for the appointment date textField
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (appointmentDate.getText().equals("yyyy,MM,dd,HH,mm")) {
                    appointmentDate.setText("");
                    appointmentDate.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        Done.addActionListener(new ActionListener() {

            /**
            action listener to check if the date format is correct or not
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                name = patientName.getText();
                phoNumber = phoneNumber.getText();
                addr = address.getText();
                String dat = dateOfBirth.getText();
                try {
                    dob = new SimpleDateFormat("dd/MM/yyyy").parse(dat);
                } catch (ParseException ex) {
                    System.out.println("Error in date!!!!");
                }
                if (jRadioButtonf.isSelected()) {

                    sex = 0;
                } else if (jRadioButton.isSelected()) {

                    sex = 1;
                }
                docName = doctorName.getText();
                medCondition = medicalCondition.getSelectedItem();
                String appodate = appointmentDate.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,MM,dd,HH,mm");
                appDate = LocalDateTime.parse(appodate, formatter);
                Patient p = new Patient(name, phoNumber, addr, dob, sex, docName, medCondition, appDate);

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("patient.dat",true))) {
                        bw.write(p.toString());
                        bw.newLine();

                } catch (Exception event) {
                    event.printStackTrace();
                }

                GUIFirst f = new GUIFirst();
                dispose();
            }
        });
    }
}
