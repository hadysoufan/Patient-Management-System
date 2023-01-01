import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiAddClinic extends JFrame {

    /**
     * data fields
     */
    String Name;
    int maxnbofpatients;
    JLabel NameClinic, MaxNumberOfPatients, image;
    JTextField Clinicname, nbofpatients;
    ImageIcon img;

    public guiAddClinic() {

        /**
         constructor with all required methods
         */

        final Container cp = getContentPane();
        cp.setLayout(new GridLayout(8, 1));

        JPanel p1 = new JPanel(new GridLayout(5, 2, 3, 3));
        JPanel p2 = new JPanel(new FlowLayout());


        /**
         implementing all data fields with the right code
         */

        img = new ImageIcon(new ImageIcon(getClass().getResource("assets/addClinics.gif")).getImage());
        image = new JLabel(img);

        NameClinic = new JLabel("Clinic Name");
        MaxNumberOfPatients = new JLabel("Max Number Of Patients");

        Clinicname = new JTextField(2);
        nbofpatients = new JTextField(2);

        JButton Done = new JButton("DONE");
        JButton back = new JButton("BACK");


        /**
         adding all data fields to the panel
         */

        p2.add(image);
        p1.add(NameClinic);
        p1.add(Clinicname);
        p1.add(MaxNumberOfPatients);
        p1.add(nbofpatients);
        p1.add(back);
        p1.add(Done);
        cp.add(p2);
        cp.add(p1);


        /**
         adding background color
         */

        back.setBackground(new Color(0, 160, 180));
        Done.setBackground(new Color(0, 160, 160));
        nbofpatients.setBackground(new Color(225, 230, 230));
        Clinicname.setBackground(new Color(225, 230, 230));

        /**
         adding font color
         */

        NameClinic.setForeground(new Color(20, 160, 160));
        MaxNumberOfPatients.setForeground(new Color(0, 160, 160));
        Clinicname.setForeground(new Color(0, 160, 160));
        back.setForeground(Color.white);
        nbofpatients.setForeground(new Color(0, 160, 160));

        Done.setBackground(new Color(255, 0, 0));


        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(p1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Clinic");
        setSize(1550, 820);
        setVisible(true);

        back.addActionListener(new ActionListener() {
            /**
            action listener that render the GUIThird panel
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIThird f = new GUIThird();
                dispose();
            }
        });
        Done.addActionListener(new ActionListener() {
            /**
             action listener that render multiple components
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                Name = Clinicname.getText();
                String NumberOfPatients = nbofpatients.getText();
                maxnbofpatients = Integer.parseInt(NumberOfPatients);
                Clinic c = new Clinic(Name, maxnbofpatients);
                GUIFirst f = new GUIFirst();
                dispose();
            }
        });
    }

}
