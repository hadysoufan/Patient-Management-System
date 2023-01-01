import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiPatientList extends JFrame {

    JLabel title, list, name;
    JButton back, ok;
    JTextField nameTF;

    public guiPatientList() {
        Font f = new Font("", 10, 16);
        final Container cp = getContentPane();
        cp.setLayout(new GridLayout(4, 1));
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());
        JPanel p4 = new JPanel(new FlowLayout((FlowLayout.LEFT)));
        title = new JLabel("List of Patients in a Clinic");
        name = new JLabel("Write the name of the clinic: ");
        nameTF = new JTextField(10);
        list = new JLabel();
        back = new JButton("Back");
        ok = new JButton("OK");

        title.setFont(f);

        title.setForeground(new Color(0, 160, 160));
        name.setForeground(new Color(0, 160, 180));
        list.setForeground(new Color(10, 160, 180));

        nameTF.setForeground(new Color(0, 160, 160));
        nameTF.setBackground(new Color(225, 230, 230));

        back.setBackground(new Color(0, 160, 180));
        back.setForeground(Color.white);
        ok.setBackground(new Color(0, 180, 160));
        ok.setForeground(Color.white);

        p1.add(title);
        p2.add(name);
        p2.add(nameTF);
        p2.add(ok);
        p3.add(list);
        p4.add(back);
        cp.add(p1);
        cp.add(p2);
        cp.add(p3);
        cp.add(p4);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int x = 0;
                for (int i = 0; i < Clinic.clinicList.size(); i++) {
                    if (nameTF.getText().equals(Clinic.clinicList.get(i).getName())) {
                        x = 1;
                        list.setText(Clinic.clinicList.get(i).getListOfPatient().toString());
                    }
                }
                if (x == 0) {
                    list.setText("Clinic not found!");
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIThird f = new GUIThird();
                dispose();
            }
        });
        setTitle("Pure Health Clinic");
        setSize(1550, 820);
        setVisible(true);
    }

}
