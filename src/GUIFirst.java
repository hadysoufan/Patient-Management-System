import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFileChooser;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

public class GUIFirst extends JFrame {

    /**
     * data fields
     */
    JLabel image, page;
    JButton patient, clinic, prescription, open, searchButton, search;
    ImageIcon img;
    JTextArea textArea;
    JScrollPane scrollPane;
    String[] messages = {"The Pure Health Clinic", "Your one-stop shop for all your health needs", "Come see us today!"};
    int index = 0;

    public GUIFirst() {

        /**
        constructor that implements all the data fields
         */

        Font f = new Font("", 10, 20);
        final Container cp = getContentPane();
        cp.setLayout(new GridLayout(5, 1));
        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());
        JPanel p4 = new JPanel();
        scrollPane = new JScrollPane();

        img = new ImageIcon(new ImageIcon(getClass().getResource("assets/image.png")).getImage());
        image = new JLabel(img);

        page = new JLabel("The Pure Health Clinic", JLabel.CENTER);
        page.setFont(new Font("", Font.PLAIN, 30));

        patient = new JButton(new ImageIcon(getClass().getResource("assets/patient.png")));
        clinic = new JButton(new ImageIcon(getClass().getResource("assets/clinic.png")));
        prescription = new JButton(new ImageIcon(getClass().getResource("assets/prescription.png")));
        open = new JButton(new ImageIcon(getClass().getResource("assets/open.png")));
        search = new JButton(new ImageIcon(getClass().getResource("assets/search.png")));

        patient.setBackground(new Color(0, 160, 180));
        prescription.setBackground(new Color(0, 160, 180));
        clinic.setBackground(new Color(0, 160, 160));
        open.setBackground(new Color(0, 160, 180));
        search.setBackground(new Color(0, 160, 180));

        p2.add(image);
        p1.add(page);
        p3.add(patient);
        p3.add(clinic);
        p3.add(prescription);
        p3.add(open);
        p3.add(search);
        cp.add(p2);
        cp.add(p1);
        cp.add(p3);

        patient.addActionListener(new ActionListener() {
            /**
            action listener that render the GUIsec for creating new patient
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIsec f = new GUIsec();
                dispose();
            }
        });
        prescription.addActionListener(new ActionListener() {
            /**
            action listener that render the GUIForth for creating new prescription
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIForth f = new GUIForth();
                dispose();
            }
        });
        clinic.addActionListener(new ActionListener() {
            /**
             action listener that render the GUIForth for creating new clinic
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIThird f = new GUIThird();
                dispose();
            }
        });
        open.addActionListener(new ActionListener() {
            /**
            action listener that have a JFileChooser which allow the user to open
             any file and read it using FileInputStream and then display it
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                JFileChooser fc = new JFileChooser();
                fc.showOpenDialog(open);
                File f = fc.getSelectedFile();

                try {
                    FileInputStream fi = new FileInputStream(f);
                    byte[] b = new byte[fi.available()];
                    fi.read(b);
                    String str = new String(b);
                    fi.close();

                    cp.add(scrollPane);

                    textArea = new JTextArea();

                    scrollPane.setViewportView(textArea);
                    textArea.setText(str);

                    cp.add(p4);
                } catch (Exception e) {
                    System.out.println("Error !!!");
                }
            }

        });

        Timer timer = new Timer(1000, new ActionListener() {
            /**
            Timer method that after 1 sec, the index of the messages array changes
             and display the new index instead
             */
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
