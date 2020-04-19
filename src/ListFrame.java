import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListFrame extends JFrame {
   public JTextArea listTa;
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
        JScrollPane scroll = new JScrollPane(listTa);
        scroll.setBounds(20, 20, 540, 250);
        getContentPane().add(scroll);

        backBtn = new JButton("BACK");
        backBtn.setBounds(200, 300, 200, 30);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.menuFrame.repaint();
                Client.menuFrame.setVisible(true);
                Client.listFrame.setVisible(false);
            }
        });
        add(backBtn);
    }
}
