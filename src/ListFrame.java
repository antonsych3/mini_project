import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListFrame extends JFrame {
    private JTextArea listTa;
    private JButton backBtn;

    public ListFrame() {
        setTitle("STUDENTS APPLICATION");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        listTa = new JTextArea();
        listTa.setBounds(20, 20, 540, 250);
        listTa.setEditable(false);
        add(listTa);

        backBtn = new JButton("BACK");
        backBtn.setBounds(200, 300, 200, 30);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.menuFrame.setVisible(true);
                Main.listFrame.setVisible(false);
            }
        });
        add(backBtn);


    }
}
