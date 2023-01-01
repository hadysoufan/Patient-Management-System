import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiAddPrescription extends JFrame {


    int IDd;
    int patientId;
    String Dat;
    String dName;
    String dType;
    String dDuration;
    String dAdvice;

    JLabel ID, patientID, Date, drugName, drugType, drugDuration, drugAdvice, image, page;
    JTextField id, patientIds, date, drugname, drugtype, drugduration, drugadvice;
    ImageIcon img;

    public guiAddPrescription() {

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

        img = new ImageIcon(new ImageIcon(getClass().getResource("assets/createpre.png")).getImage());
        image = new JLabel(img);

        page = new JLabel("Create new Prescription", JLabel.CENTER);
        page.setFont(new Font("", Font.PLAIN, 30));

        ID = new JLabel("Prescription ID");
        patientID = new JLabel("Patient ID");
        Date = new JLabel("Date");
        drugName = new JLabel("Drug name");
        drugType = new JLabel("Drug Type");
        drugDuration = new JLabel("Drug Duration");
        drugAdvice = new JLabel("Drug Advice");

        id = new JTextField(2);
        patientIds = new JTextField(2);
        date = new JTextField(2);
        drugname = new JTextField(2);
        drugtype = new JTextField(2);
        drugduration = new JTextField(2);
        drugadvice = new JTextField(2);

        JButton Done = new JButton("DONE");
        JButton back = new JButton("BACK");

        ID.setForeground(new Color(0, 160, 160));
        patientID.setForeground(new Color(0, 160, 180));
        Date.setForeground(new Color(10, 160, 180));
        drugName.setForeground(new Color(10, 180, 180));
        drugType.setForeground(new Color(10, 180, 160));
        drugDuration.setForeground(new Color(0, 180, 160));
        drugAdvice.setForeground(new Color(0, 160, 160));

        id.setForeground(new Color(0, 160, 160));
        patientIds.setForeground(new Color(0, 160, 180));
        date.setForeground(new Color(10, 160, 180));
        drugname.setForeground(new Color(10, 180, 180));
        drugtype.setForeground(new Color(10, 180, 160));
        drugduration.setForeground(new Color(0, 180, 160));
        drugadvice.setForeground(new Color(0, 160, 160));

        id.setBackground(new Color(225, 230, 230));
        patientIds.setBackground(new Color(225, 230, 230));
        date.setBackground(new Color(225, 230, 230));
        drugname.setBackground(new Color(225, 230, 230));
        drugtype.setBackground(new Color(225, 230, 230));
        drugduration.setBackground(new Color(225, 230, 230));
        drugadvice.setBackground(new Color(225, 230, 230));

        back.setBackground(new Color(0, 160, 180));
        Done.setBackground(new Color(0, 180, 160));

        back.setForeground(Color.white);
        Done.setForeground(Color.white);

//        JPanel p1 = new JPanel(new GridLayout(9, 2, 3, 3));
        p1.add(image);
        p.add(page);
        p2.add(patientID);
        p2.add(patientIds);
        p2.add(Date);
        p2.add(date);
        p2.add(drugName);
        p2.add(drugname);
        p2.add(drugType);
        p2.add(drugtype);
        p2.add(drugDuration);
        p2.add(drugduration);
        p2.add(drugAdvice);
        p2.add(drugadvice);
        p2.add(back);
        p2.add(Done);
        cp.add(p1);
        cp.add(p);
        cp.add(p2);

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(p1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Prescription");
        setSize(1550, 820);
        setVisible(true);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                GUIForth f = new GUIForth();
                dispose();
            }
        });
        Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String sid = id.getText();
                IDd = Integer.parseInt(sid);
                String pid = patientIds.getText();
                patientId = Integer.parseInt(pid);
                Dat = date.getText();
                dName = drugname.getText();
                dType = drugtype.getText();
                dDuration = drugduration.getText();
                dAdvice = drugadvice.getText();
                Prescription p = new Prescription(IDd, patientId, Dat, dName, dType, dDuration, dAdvice);
                GUIFirst f = new GUIFirst();
                dispose();
            }
        });

    }
}
