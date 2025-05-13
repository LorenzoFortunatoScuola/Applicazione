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

        JTextField emailField = new JTextField("utente@esempio.com"); //una volta implementato l'accesso con google automaticamente viene inserita quella del proprio account
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
            JPanel panel = new JPanel(new GridLayout(0, 1));
            JPasswordField newPasswordField = new JPasswordField();
            JPasswordField confirmPasswordField = new JPasswordField();

            panel.add(new JLabel("Nuova Password:"));
            panel.add(newPasswordField);
            panel.add(new JLabel("Conferma Password:"));
            panel.add(confirmPasswordField);

            int result = JOptionPane.showConfirmDialog(homeFrame, panel, "Cambia Password",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String nuovaPassword = new String(newPasswordField.getPassword());
                String confermaPassword = new String(confirmPasswordField.getPassword());

                if (nuovaPassword.isEmpty() || confermaPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(homeFrame, "I campi non possono essere vuoti.", "Errore", JOptionPane.ERROR_MESSAGE);
                } else if (!nuovaPassword.equals(confermaPassword)) {
                    JOptionPane.showMessageDialog(homeFrame, "Le password non coincidono.", "Errore", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Aggiorna visivamente la password nel campo (dimostrativo)
                    passwordField.setText(nuovaPassword);
                    JOptionPane.showMessageDialog(homeFrame, "Password aggiornata con successo.");
                }
            }
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
