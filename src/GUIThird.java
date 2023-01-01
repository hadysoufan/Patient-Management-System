import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIThird extends JFrame {

    /**
    data fields
     */
    JLabel page, image;
    JButton addP, addC, remove, back, move, pList, p_m_c, history;

    ImageIcon img;

    public GUIThird() {

        /**
         constructor with all required methods
         */

        Font f = new Font("", 15, 20);

        final Container cp = getContentPane();
        cp.setLayout(new GridLayout(8, 1));

        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p6 = new JPanel(new BorderLayout());

        /**
         implementing all data fields with the right code
         */

        img = new ImageIcon(new ImageIcon(getClass().getResource("assets/patientHealthClinic.gif")).getImage());
        image = new JLabel(img);

        addP = new JButton("Add Patient");
        move = new JButton("Move Patient");
        p_m_c = new JButton("Patient List by Medical Condition");
        pList = new JButton("Patient List");
        addC = new JButton("Add Clinic");
        back = new JButton("Back");
        remove = new JButton("Remove Patient");
        history = new JButton("Patient History");
        page = new JLabel("Welcome to Pure Health Clinic", JLabel.CENTER);


        /**
         adding background color
         */

        page.setFont(f);

        addP.setBackground(new Color(20, 160, 160));
        addC.setBackground(new Color(0, 180, 160));
        back.setBackground(new Color(0x17, 0x17, 0x17));
        history.setBackground(new Color(0, 160, 160));
        p_m_c.setBackground(new Color(20, 160, 160));
        move.setBackground(new Color(0, 180, 160));
        pList.setBackground(new Color(10, 180, 160));
        remove.setBackground(new Color(10, 180, 180));

        /**
         adding font color
         */

        page.setForeground(new Color(20, 160, 160));
        addP.setForeground(Color.white);
        addC.setForeground(Color.white);
        back.setForeground(Color.white);
        move.setForeground(Color.white);
        p_m_c.setForeground(Color.white);
        pList.setForeground(Color.white);
        remove.setForeground(Color.white);
        history.setForeground(Color.white);


        /**
         adding all data fields to the panel
         */

        p6.add(image);
        p1.add(page);
        p2.add(addC);
        p2.add(pList);
        p3.add(addP);
        p3.add(remove);
        p3.add(history);
        p4.add(move);
        p4.add(p_m_c);
        p5.add(back);
        cp.add(p6);
        cp.add(p1);
        cp.add(p2);
        cp.add(p3);
        cp.add(p4);
        cp.add(p5);

        addC.addActionListener(new ActionListener() {
            /**
             ActionListener that render the add clinic panel
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                guiAddClinic f = new guiAddClinic();
                dispose();
            }
        });
        pList.addActionListener(new ActionListener() {
            /**
             ActionListener that render the add patient list panel
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                guiPatientList f = new guiPatientList();
                dispose();
            }
        });
        back.addActionListener(new ActionListener() {
            /**
             ActionListener that render the GUIFirst panel
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIFirst f = new GUIFirst();
                dispose();
            }
        });
        addP.addActionListener(new ActionListener() {
            /**
             ActionListener that render the add patient panel
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                addPatient p = new addPatient();
                dispose();
            }
        });
        remove.addActionListener(new ActionListener() {
            /**
             ActionListener that render the remove patient panel
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                removePatient p = new removePatient();
                dispose();
            }
        });
        history.addActionListener(new ActionListener() {
            /**
             ActionListener that render the guiPatientHistory panel
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                guiPatientHistory p = new guiPatientHistory();
                dispose();
            }
        });
        move.addActionListener(new ActionListener() {
            /**
             ActionListener that render the guiMovePatient panel
             */

            @Override
            public void actionPerformed(ActionEvent evt) {
                guiMovePatient f = new guiMovePatient();
                dispose();
            }
        });
        p_m_c.addActionListener(new ActionListener() {

            /**
             ActionListener that render the guiGetListOfPatientsByMedicalCondition panel
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                guiGetListOfPatientsByMedicalCondition f = new guiGetListOfPatientsByMedicalCondition();
                dispose();
            }
        });

        setTitle("Patient Management System");
        setSize(1500, 1024);
        setVisible(true);
    }


}
