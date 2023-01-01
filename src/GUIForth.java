import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GUIForth extends JFrame {

    JLabel page, prescInfo, image;
    JButton add, info, back;
    JTextField presc;
    ImageIcon img;
    public GUIForth() {

        Font f = new Font("", 10, 20);
        final Container cp = getContentPane();
        cp.setLayout(new GridLayout(3, 1));
        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());

        img = new ImageIcon(new ImageIcon(getClass().getResource("assets/prescription.gif")).getImage());
        image = new JLabel(img);

        add = new JButton("Add Prescription");
        back = new JButton("Back");
        info = new JButton("Show Prescription");
        page = new JLabel("The Pure Health Prescription", JLabel.CENTER);
        prescInfo = new JLabel("");
        presc = new JTextField("Enter Prescription ID", 10);

        page.setFont(f);

        add.setBackground(new Color(0, 180, 160));
        presc.setBackground(new Color(225, 230, 230));
        back.setBackground(new Color(0, 160, 180));
        info.setBackground(new Color(20, 160, 160));
        prescInfo.setBackground(new Color(20, 160, 160));

        page.setForeground(new Color(20, 160, 160));
        add.setForeground(Color.white);
        presc.setForeground(new Color(0, 160, 160));
        back.setForeground(Color.white);
        info.setForeground(Color.white);
        prescInfo.setForeground(new Color(0, 160, 160));

        p1.add(image);
        p2.add(page);
        p3.add(add);
        p3.add(info);
        p3.add(presc);
        p3.add(back);
        cp.add(p1);
        cp.add(p2);
        cp.add(p3);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                guiAddPrescription f = new guiAddPrescription();
                dispose();
            }
        });
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                p3.add(prescInfo);
                int c = 0;
                for (int i = 0; i < (Prescription.ids).size(); i++) {
                    if (((Prescription.ids).get(i)).getID() == Integer.parseInt(presc.getText())) {
                        prescInfo.setText(Prescription.ids.get(i).showPrescription(i));
                        c++;
                    }
                }
                if (c == 0) {
                    prescInfo.setText("Prescription not found!");
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIFirst f = new GUIFirst();
                dispose();
            }
        });

        presc.addFocusListener(new FocusListener() {
            /**
             creating a placeholder for the patient textField
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (presc.getText().equals("Enter Prescription ID")) {
                    presc.setText("");
                    presc.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        setTitle("Pure Health Clinic");
        setSize(1550, 820);
        setVisible(true);
    }



}
