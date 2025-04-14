package progettoapplicazione;

import javax.swing.*;
import java.awt.event.*;

public class ProgettoApplicazione {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Finestra");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton button = new JButton("Cliccami");
        button.setBounds(90, 70, 120, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Hai cliccato il bottone");
            }
        });

        frame.add(button);
        frame.setVisible(true);
    }
}
