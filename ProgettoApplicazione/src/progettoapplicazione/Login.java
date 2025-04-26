package progettoapplicazione;

import javax.swing.*;
import java.awt.*;

public class Login {

    private JFrame loginFrame;

    public Login() {
        Login();
    }

    private void Login() {
        loginFrame = new JFrame("CleverCircuit Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(600, 400);
        loginFrame.setLocationRelativeTo(null);

        // Colori principali
        Color backgroundColor = new Color(240, 248, 255);
        Color buttonColor = new Color(100, 149, 237);
        Color textColor = new Color(25, 25, 112);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        mainPanel.setBackground(backgroundColor);

        // Titolo principale
        JLabel titleLabel = new JLabel("CIAO, BENVENUTO SU CLEVER CIRCUIT");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(textColor);

        // Sottotitolo
        JLabel subtitleLabel = new JLabel("La prima applicazione per la simulazione di risolutori logici.");
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setForeground(textColor.darker());

        Dimension spacer = new Dimension(0, 50);

        // Label accedi/registrati
        JLabel loginLabel = new JLabel("Accedi / Registrati");
        loginLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginLabel.setForeground(textColor);

        // Bottone di autenticazione Google
        JButton googleButton = new JButton("Accedi con Google");
        googleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        googleButton.setMaximumSize(new Dimension(250, 50));
        googleButton.setBackground(buttonColor);
        googleButton.setForeground(Color.BLACK); // Testo nero come volevi
        googleButton.setFocusPainted(false);
        googleButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        googleButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        googleButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(loginFrame, "Funzione di autenticazione in sviluppo");
            loginFrame.dispose(); // Chiude la finestra di login
            new Home(); // Avvia la home
        });

        // Aggiunta dei componenti
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(subtitleLabel);
        mainPanel.add(Box.createRigidArea(spacer));
        mainPanel.add(loginLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(googleButton);

        loginFrame.add(mainPanel);
        loginFrame.setVisible(true);
    }
}
