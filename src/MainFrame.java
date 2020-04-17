import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame {
    private JButton addBtn, listBtn, exitBtn;

    public MainFrame() {
        setTitle("STUDENTS APPLICATION");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        addBtn = new JButton("ADD STUDENT");
        addBtn.setBounds(200, 100, 200, 30);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.addFrame.setVisible(true);
                Main.menuFrame.setVisible(false);
            }
        });
        add(addBtn);

        listBtn = new JButton("LIST STUDENTS");
        listBtn.setBounds(200, 150, 200, 30);
        listBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.outStream.writeObject(new PackageData("LIST_STUDENTS"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                Main.listFrame.setVisible(true);
                Main.menuFrame.setVisible(false);
            }
        });
        add(listBtn);

        exitBtn = new JButton("EXIT");
        exitBtn.setBounds(200, 200, 200, 30);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitBtn);
    }
}
