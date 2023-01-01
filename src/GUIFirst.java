import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFirst extends JFrame {

    /**
    data fields
     */
    JLabel image, page;
    JButton patient, clinic, prescription, save;
    ImageIcon img;

    String[] messages = {"The Pure Health Clinic", "Your one-stop shop for all your health needs", "Come see us today!"};
    int index = 0;

    public GUIFirst() {



        Font f = new Font("", 10, 20);
        final Container cp = getContentPane();
        cp.setLayout(new GridLayout(3, 1));
        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());

        img = new ImageIcon(new ImageIcon(getClass().getResource("assets/image.png")).getImage());
        image = new JLabel(img);

        page = new JLabel("The Pure Health Clinic", JLabel.CENTER);
        page.setFont(new Font("", Font.PLAIN, 30));


        patient = new JButton(new ImageIcon(getClass().getResource("assets/patient.png")));
        clinic = new JButton(new ImageIcon(getClass().getResource("assets/clinic.png")));
        prescription = new JButton(new ImageIcon(getClass().getResource("assets/prescription.png")));
        save = new JButton(new ImageIcon(getClass().getResource("assets/save.png")));


        p2.add(image);
        p1.add(page);
        p3.add(patient);
        p3.add(clinic);
        p3.add(prescription);
        p3.add(save);
        cp.add(p2);
        cp.add(p1);
        cp.add(p3);




        patient.setBackground(new Color(0, 160, 180));
        prescription.setBackground(new Color(0, 160, 180));
        clinic.setBackground(new Color(0, 160, 160));
        save.setBackground(new Color(0, 160, 180));

        patient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIsec f = new GUIsec();
                dispose();
            }
        });
        prescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIForth f = new GUIForth();
                dispose();
            }
        });
        clinic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIThird f = new GUIThird();
                dispose();
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

            }
        });

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page.setText(messages[index]);
                index = (index + 1) % messages.length;
            }
        });
        timer.start();

        pack();
        setTitle("Pure Health Clinic");
        setSize(1550, 820);
        setVisible(true);


    }


    public static void main(String[] args) {
        new GUIFirst();
    }
}
