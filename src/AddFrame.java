import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class AddFrame extends JFrame {
    private JLabel nameLbl, surnameLbl, ageLbl;
    private JTextField nameTf, surnameTf;
    private JComboBox ageCb;
    private JButton addBtn, backBtn;

    public AddFrame () {
        setTitle("STUDENTS APPLICATION");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        nameLbl = new JLabel("NAME:");
        nameLbl.setBounds(100, 60, 200, 30);
        add(nameLbl);

        surnameLbl = new JLabel("SURNAME");
        surnameLbl.setBounds(100, 110, 200, 30);
        add(surnameLbl);

        ageLbl = new JLabel("AGE:");
        ageLbl.setBounds(100, 160, 200, 30);
        add(ageLbl);

        nameTf = new JTextField();
        nameTf.setBounds(250, 60, 250, 30);
        add(nameTf);

        surnameTf = new JTextField();
        surnameTf.setBounds(250, 110, 250, 30);
        add(surnameTf);

        ageCb = new JComboBox();
        ageCb.setBounds(250, 160, 250, 30);
        for (int i = 0; i < 100; i++) {
            ageCb.addItem(i);
        }
        ageCb.setSelectedIndex(25);
        add(ageCb);

        addBtn = new JButton("ADD");
        addBtn.setBounds(100, 210, 180, 30);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.outStream.writeObject(new PackageData("ADD_STUDENT"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                repaint();
            }
        });
        add(addBtn);

        backBtn = new JButton("BACK");
        backBtn.setBounds(320, 210, 180, 30);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.menuFrame.setVisible(true);
                Main.addFrame.setVisible(false);
            }
        });
        add(backBtn);
    }
}
