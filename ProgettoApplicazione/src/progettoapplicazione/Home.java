package progettoapplicazione;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JMenuItem temaItem = new JMenuItem("Tema");
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
        temaItem.addActionListener(e -> openSettingsWindow("Tema"));
        lingueItem.addActionListener(e -> openSettingsWindow("Lingue e località"));
        notificheItem.addActionListener(e -> openSettingsWindow("Notifiche"));
        privacyItem.addActionListener(e -> openSettingsWindow("Privacy"));
        versioneItem.addActionListener(e -> openSettingsWindow("Versione"));

        // Aggiungi gli elementi al menu
        accountSubMenu.add(logoutItem);
        accountSubMenu.add(eliminaAccountItem);
        accountSubMenu.add(cambiaAccountItem);

        impostazioniSubMenu.add(temaItem);
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
            homeFrame.dispose(); // Chiude la finestra home
            new Project(); // Avvia il progetto
        });
        storicoBtn.addActionListener(e -> {
            homeFrame.dispose(); // Chiude la finestra home
            new Storico(); // Avvia lo storico
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

    // Funzione per aprire la finestra delle impostazioni
    private void openSettingsWindow(String settingType) {
        JFrame settingsFrame = new JFrame(settingType);
        settingsFrame.setSize(400, 300);
        settingsFrame.setLocationRelativeTo(homeFrame);
        settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Impostazioni per: " + settingType, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 18));

        panel.add(label, BorderLayout.CENTER);
        settingsFrame.add(panel);
        settingsFrame.setVisible(true);
    }

    // MOSTRA ABOUT US
    private void showAboutUs() {
        centerPanel.removeAll();

        JLabel aboutLabel = new JLabel("Qui parleremo un po' di noi...");
        aboutLabel.setFont(new Font("SansSerif", Font.ITALIC, 20));
        aboutLabel.setForeground(new Color(25, 25, 112));
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.add(aboutLabel);

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

    // Funzione per mostrare la home
    private void Home() {
        centerPanel.removeAll();  // Rimuovi i componenti esistenti
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 100));

        // Crea i bottoni per la home
        JButton nuovoProgettoBtn = new JButton("Nuovo Progetto");
        JButton storicoBtn = new JButton("Storico Progetti");

        for (JButton btn : new JButton[]{nuovoProgettoBtn, storicoBtn}) {
            btn.setPreferredSize(new Dimension(200, 60));
            btn.setBackground(new Color(100, 149, 237));
            btn.setForeground(Color.BLACK);
            btn.setFont(new Font("SansSerif", Font.BOLD, 16));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            centerPanel.add(btn);
        }

        centerPanel.revalidate();
        centerPanel.repaint();
    }
}
