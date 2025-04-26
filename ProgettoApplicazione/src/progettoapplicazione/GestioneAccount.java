package progettoapplicazione;

import javax.swing.*;
import java.awt.*;

public class GestioneAccount extends JPanel {

    public GestioneAccount(JFrame homeFrame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(240, 248, 255));

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField emailField = new JTextField("utente@esempio.com");
        emailField.setMaximumSize(new Dimension(300, 30));
        emailField.setHorizontalAlignment(JTextField.CENTER);
        emailField.setEditable(false);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField passwordField = new JPasswordField("passwordfinta");
        passwordField.setMaximumSize(new Dimension(300, 30));
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setEditable(false);

        JButton cambiaPasswordBtn = new JButton("Cambia Password");
        cambiaPasswordBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        cambiaPasswordBtn.setBackground(new Color(100, 149, 237));
        cambiaPasswordBtn.setForeground(Color.BLACK);
        cambiaPasswordBtn.setFocusPainted(false);
        cambiaPasswordBtn.setFont(new Font("SansSerif", Font.BOLD, 16));

        cambiaPasswordBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(homeFrame, "Funzione di cambio password in sviluppo");
        });

        add(Box.createVerticalStrut(20));
        add(emailLabel);
        add(emailField);
        add(Box.createVerticalStrut(20));
        add(passwordLabel);
        add(passwordField);
        add(Box.createVerticalStrut(30));
        add(cambiaPasswordBtn);
    }
}
