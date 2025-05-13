package progettoapplicazione;

import javax.swing.*;
import java.awt.*;

public class Home {

    private JFrame homeFrame;
    private JPanel centerPanel;
    private JPanel titlePanel;

    public Home() {
        home();
    }

    private void home() {
        homeFrame = new JFrame("CleverResolutor");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setSize(800, 500);
        homeFrame.setLocationRelativeTo(null);

        Color backgroundColor = new Color(240, 248, 255);
        Color buttonColor = new Color(100, 149, 237);
        Color textColor = new Color(25, 25, 112);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(backgroundColor);

        // HEADER
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(backgroundColor);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // LOGO BUTTON
        JButton logoButton = new JButton("LOGO");
        logoButton.setPreferredSize(new Dimension(50, 50));
        logoButton.setFont(new Font("SansSerif", Font.BOLD, 10));
        logoButton.setForeground(Color.WHITE);
        logoButton.setBackground(buttonColor);
        logoButton.setFocusPainted(false);
        logoButton.setBorderPainted(false);
        logoButton.setContentAreaFilled(false);

        logoButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(buttonColor);
                g2.fillOval(0, 0, c.getWidth(), c.getHeight());
                g2.setColor(Color.WHITE);
                g2.setFont(new Font("SansSerif", Font.BOLD, 10));
                FontMetrics fm = g2.getFontMetrics();
                String text = "LOGO";
                int x = (c.getWidth() - fm.stringWidth(text)) / 2;
                int y = (c.getHeight() + fm.getAscent() - fm.getDescent()) / 2;
                g2.drawString(text, x, y);
            }
        });

        logoButton.addActionListener(e -> showAboutUs());

        // TITOLO E SOTTOTITOLO
        titlePanel = new JPanel();
        titlePanel.setBackground(backgroundColor);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("CleverResolutor", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setForeground(textColor);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        titlePanel.add(titleLabel);

        // MENU A TENDINA
        JButton menuButton = new JButton("≡");
        menuButton.setFont(new Font("SansSerif", Font.BOLD, 24));
        menuButton.setFocusPainted(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorderPainted(false);
        menuButton.setForeground(textColor);

        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem homeItem = new JMenuItem("Home");
        JMenuItem pianiItem = new JMenuItem("Piani a pagamento");
        JMenuItem gestisciAccountItem = new JMenuItem("Gestisci Account");
        JMenuItem impostazioniItem = new JMenuItem("Impostazioni");
        JMenuItem aiutoItem = new JMenuItem("Aiuto / Contatti");

        // Aggiungi azione per il menu Aiuto/Contatti
        aiutoItem.addActionListener(e -> {
            // Crea e mostra la finestra dei contatti
            JFrame contattiFrame = new JFrame("Aiuto / Contatti");
            contattiFrame.setSize(400, 300);
            contattiFrame.setLocationRelativeTo(homeFrame);
            contattiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Crea il pannello dei contatti
            Contatti contattiPanel = new Contatti(homeFrame);
            contattiFrame.add(contattiPanel);
            contattiFrame.setVisible(true);
        });

        // Sottomenu Account
        JMenu accountSubMenu = new JMenu("Account");
        JMenuItem logoutItem = new JMenuItem("Logout");
        JMenuItem eliminaAccountItem = new JMenuItem("Elimina Account");
        JMenuItem cambiaAccountItem = new JMenuItem("Cambia Account");

        // Sottomenu Impostazioni
        JMenu impostazioniSubMenu = new JMenu("Impostazioni");
        JMenuItem lingueItem = new JMenuItem("Lingue e località");
        JMenuItem notificheItem = new JMenuItem("Notifiche");
        JMenuItem privacyItem = new JMenuItem("Privacy");
        JMenuItem versioneItem = new JMenuItem("Versione");

        // Azioni Menu
        pianiItem.addActionListener(e -> new Pagamento());

        logoutItem.addActionListener(e -> {
            homeFrame.dispose();
            new Login();
        });
        eliminaAccountItem.addActionListener(e -> {
            // Chiedi il motivo dell'eliminazione
            String motivo = JOptionPane.showInputDialog(homeFrame, "Per favore, inserisci il motivo dell'eliminazione del tuo account:");

            if (motivo != null && !motivo.isEmpty()) {
                // Chiedi l'email di conferma
                String email = JOptionPane.showInputDialog(homeFrame, "Inserisci la tua email per confermare l'eliminazione:");

                if (email != null && !email.isEmpty()) {
                    // Mostra una finestra di conferma con il motivo e l'email
                    String message = "Account eliminato con successo!\nMotivo: " + motivo + "\nEmail: " + email;
                    JOptionPane.showMessageDialog(homeFrame, message);

                    // Logica per eliminare l'account (da aggiungere al backend se necessario)
                    homeFrame.dispose();  // Chiudi la finestra
                    new Login();  // Torna alla schermata di login
                } else {
                    JOptionPane.showMessageDialog(homeFrame, "Email non fornita. L'eliminazione non può essere completata.");
                }
            } else {
                JOptionPane.showMessageDialog(homeFrame, "Motivo non fornito. L'eliminazione non può essere completata.");
            }
        });
        cambiaAccountItem.addActionListener(e -> {
            int conferma = JOptionPane.showConfirmDialog(homeFrame, "Sei sicuro di voler cambiare account?", "Cambia Account", JOptionPane.YES_NO_OPTION);
            if (conferma == JOptionPane.YES_OPTION) {
                homeFrame.dispose();
                new Login();
            }
        });

        gestisciAccountItem.addActionListener(e -> {
            centerPanel.removeAll();
            centerPanel.setLayout(new BorderLayout());
            centerPanel.add(new GestioneAccount(homeFrame), BorderLayout.CENTER);
            centerPanel.revalidate();
            centerPanel.repaint();
        });

        // Impostazioni - Azioni con nuove finestre
        lingueItem.addActionListener(e -> openSettingsWindow("Lingue e località", "Configura le lingue e la località"));
        notificheItem.addActionListener(e -> openSettingsWindow("Notifiche", "Nessuna notifica al momento"));
        privacyItem.addActionListener(e -> openSettingsWindow("Privacy", "Imposta le tue preferenze sulla privacy"));
        versioneItem.addActionListener(e -> openSettingsWindow("Versione", "Versione 1.0.0.0"));

        // Aggiungi gli elementi al menu
        accountSubMenu.add(logoutItem);
        accountSubMenu.add(eliminaAccountItem);
        accountSubMenu.add(cambiaAccountItem);

        impostazioniSubMenu.add(lingueItem);
        impostazioniSubMenu.add(notificheItem);
        impostazioniSubMenu.add(privacyItem);
        impostazioniSubMenu.add(versioneItem);

        popupMenu.add(pianiItem);
        popupMenu.add(accountSubMenu);
        popupMenu.add(gestisciAccountItem);
        popupMenu.add(impostazioniSubMenu);
        popupMenu.add(aiutoItem);

        menuButton.addActionListener(e -> popupMenu.show(menuButton, menuButton.getWidth(), menuButton.getHeight()));

        // HEADER layout
        headerPanel.add(logoButton, BorderLayout.WEST);
        headerPanel.add(titlePanel, BorderLayout.CENTER);
        headerPanel.add(menuButton, BorderLayout.EAST);

        // PANNELLO CENTRALE
        centerPanel = new JPanel();
        centerPanel.setBackground(backgroundColor);
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 100));

        JButton nuovoProgettoBtn = new JButton("Nuovo Progetto");
        JButton storicoBtn = new JButton("Storico Progetti");
        nuovoProgettoBtn.addActionListener(e -> {
            new CreaFile();
            homeFrame.dispose();
        });
        storicoBtn.addActionListener(e -> {
            //new Storico(); // Avvia lo storico
        });

        for (JButton btn : new JButton[]{nuovoProgettoBtn, storicoBtn}) {
            btn.setPreferredSize(new Dimension(200, 60));
            btn.setBackground(buttonColor);
            btn.setForeground(Color.BLACK);
            btn.setFont(new Font("SansSerif", Font.BOLD, 16));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            centerPanel.add(btn);
        }

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        homeFrame.add(mainPanel);
        homeFrame.setVisible(true);
    }

    // Variabili statiche per memorizzare la lingua e la località selezionate
    private static String selectedLanguage = "Italiano";  // Lingua di default
    private static String selectedLocation = "Italia";    // Località di default

    private void openSettingsWindow(String settingType, String customMessage) {
        JFrame settingsFrame = new JFrame(settingType);
        settingsFrame.setSize(400, 300);
        settingsFrame.setLocationRelativeTo(homeFrame);
        settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Solo se NON è Notifiche, Tema o Versione aggiungiamo l’intestazione in alto
        if (!settingType.equals("Notifiche") && !settingType.equals("Tema") && !settingType.equals("Versione")) {
            JLabel label = new JLabel(customMessage, SwingConstants.CENTER);
            label.setFont(new Font("SansSerif", Font.BOLD, 18));
            panel.add(label, BorderLayout.NORTH);
        }

        if (settingType.equals("Privacy")) {
            JPanel centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));
            JCheckBox cookiesCheckBox = new JCheckBox("Accetta i Cookies", true);
            JCheckBox notificationsCheckBox = new JCheckBox("Abilita notifiche", true);
            JCheckBox dataUsageCheckBox = new JCheckBox("Consento l'utilizzo dei miei dati", true);
            centerPanel.add(cookiesCheckBox);
            centerPanel.add(notificationsCheckBox);
            centerPanel.add(dataUsageCheckBox);

            panel.add(centerPanel, BorderLayout.CENTER);

            JPanel bottomPanel = new JPanel();
            JButton saveButton = new JButton("Salva");
            saveButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(settingsFrame,
                        "Preferenze salvate:\nCookies: " + (cookiesCheckBox.isSelected() ? "Accettato" : "Rifiutato")
                        + "\nNotifiche: " + (notificationsCheckBox.isSelected() ? "Abilitato" : "Disabilitato")
                        + "\nUtilizzo dati: " + (dataUsageCheckBox.isSelected() ? "Consentito" : "Non consentito"));
                settingsFrame.dispose();
            });
            bottomPanel.add(saveButton);
            panel.add(bottomPanel, BorderLayout.SOUTH);

        } else if (settingType.equals("Lingue e località")) {
            JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));

            JLabel languageLabel = new JLabel("Seleziona la lingua:");
            String[] languages = {"Italiano", "English", "Français", "Deutsch"};
            JComboBox<String> languageComboBox = new JComboBox<>(languages);
            languageComboBox.setSelectedItem(selectedLanguage);

            JLabel locationLabel = new JLabel("Seleziona la località:");
            String[] locations = {"Italia", "USA", "Francia", "Germania"};
            JComboBox<String> locationComboBox = new JComboBox<>(locations);
            locationComboBox.setSelectedItem(selectedLocation);

            centerPanel.add(languageLabel);
            centerPanel.add(languageComboBox);
            centerPanel.add(locationLabel);
            centerPanel.add(locationComboBox);

            panel.add(centerPanel, BorderLayout.CENTER);

            JPanel bottomPanel = new JPanel();
            JButton saveButton = new JButton("Salva");
            saveButton.addActionListener(e -> {
                selectedLanguage = (String) languageComboBox.getSelectedItem();
                selectedLocation = (String) locationComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(settingsFrame,
                        "Lingua: " + selectedLanguage + "\nLocalità: " + selectedLocation);
                settingsFrame.dispose();
            });
            bottomPanel.add(saveButton);
            panel.add(bottomPanel, BorderLayout.SOUTH);

        } else if (settingType.equals("Notifiche")) {
            // Solo un'etichetta al centro per le notifiche
            JLabel centerLabel = new JLabel("Nessuna notifica al momento", SwingConstants.CENTER);
            centerLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
            panel.add(centerLabel, BorderLayout.CENTER);

        } else if (settingType.equals("Tema")) {
            // Solo un'etichetta al centro per il tema
            JLabel centerLabel = new JLabel("Personalizza il tema dell'applicazione", SwingConstants.CENTER);
            centerLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
            panel.add(centerLabel, BorderLayout.CENTER);

        } else if (settingType.equals("Versione")) {
            // Solo un'etichetta al centro per la versione
            JLabel centerLabel = new JLabel("Versione 1.0.0.0", SwingConstants.CENTER);
            centerLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
            panel.add(centerLabel, BorderLayout.CENTER);

        } else {
            // Tema o Versione → messaggio generico al centro
            JLabel centerLabel = new JLabel(customMessage, SwingConstants.CENTER);
            centerLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
            panel.add(centerLabel, BorderLayout.CENTER);
        }

        settingsFrame.add(panel);
        settingsFrame.setVisible(true);
    }

    // MOSTRA ABOUT US
    private void showAboutUs() {

        centerPanel.removeAll();

        // Creazione del JLabel con il testo
        JLabel aboutLabel = new JLabel("<html><div style='text-align: center;'>"
                + "Chi Siamo<br><br>"
                + "Siamo un team appassionato di logica digitale e informatica. La nostra applicazione è progettata per semplificare il processo di risoluzione delle porte logiche, offrendo uno strumento veloce e intuitivo per studenti, ingegneri e appassionati di elettronica.<br><br>"
                + "Cosa Facciamo<br><br>"
                + "Offriamo una soluzione semplice ed efficiente per risolvere combinazioni di porte logiche, con il supporto di grafici e analisi dettagliate per ogni espressione booleana. Il nostro obiettivo è rendere l'apprendimento e la progettazione delle logiche digitali più accessibile e immediato."
                + "</div></html>");

        // Impostazioni del font (più piccolo) e colore
        aboutLabel.setFont(new Font("SansSerif", Font.ITALIC, 18));  // Font ridotto
        aboutLabel.setForeground(new Color(25, 25, 112));

        // Layout del pannello per centrare il JLabel
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Aggiungi uno spazio verticale sopra il testo per posizionarlo in alto
        centerPanel.add(Box.createVerticalStrut(20));  // Spazio ridotto per posizionarlo in alto
        centerPanel.add(aboutLabel);  // Aggiungi il JLabel
        centerPanel.add(Box.createVerticalStrut(20));  // Spazio ridotto sotto il testo

        centerPanel.revalidate();
        centerPanel.repaint();

        if (titlePanel.getComponentCount() == 1) {
            JLabel subtitle = new JLabel("ABOUT US");
            subtitle.setFont(new Font("SansSerif", Font.PLAIN, 16));
            subtitle.setForeground(new Color(25, 25, 112));
            subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            titlePanel.add(subtitle);
        }

        centerPanel.revalidate();
        centerPanel.repaint();
        titlePanel.revalidate();
        titlePanel.repaint();
    }
}
