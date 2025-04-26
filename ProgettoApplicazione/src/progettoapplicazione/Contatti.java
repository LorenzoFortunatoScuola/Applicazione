package progettoapplicazione;

import javax.swing.*;
import java.awt.*;

public class Contatti extends JPanel {

    public Contatti(JFrame homeFrame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(240, 248, 255));

        // Etichetta e campo per il numero di telefono
        JLabel telefonoLabel = new JLabel("Numero di telefono:");
        telefonoLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        telefonoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField telefonoField = new JTextField("123-456-7890");
        telefonoField.setMaximumSize(new Dimension(300, 30));
        telefonoField.setHorizontalAlignment(JTextField.CENTER);
        telefonoField.setEditable(false);

        // Etichetta e campo per l'email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField emailField = new JTextField("contatti@esempio.com");
        emailField.setMaximumSize(new Dimension(300, 30));
        emailField.setHorizontalAlignment(JTextField.CENTER);
        emailField.setEditable(false);

        // Aggiunta degli elementi al pannello
        add(Box.createVerticalStrut(20));
        add(telefonoLabel);
        add(telefonoField);
        add(Box.createVerticalStrut(20));
        add(emailLabel);
        add(emailField);
        add(Box.createVerticalStrut(30));
    }
}
