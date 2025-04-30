package progettoapplicazione;

import javax.swing.*;
import java.awt.*;

public class Pagamento {
    private JFrame pagamentoFrame;

    public Pagamento() {
        showPiani();
    }

    private void showPiani() {
        pagamentoFrame = new JFrame("CleverResolutor - Piani a pagamento");
        pagamentoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pagamentoFrame.setSize(750, 500);
        pagamentoFrame.setLocationRelativeTo(null);

        // Colori
        Color backgroundColor = new Color(240, 248, 255);
        Color textColor = new Color(25, 25, 112);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(backgroundColor);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Titolo
        JLabel titleLabel = new JLabel("CleverResolutor", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
        titleLabel.setForeground(textColor);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Piani 1, 2, 3
        mainPanel.add(creaPiano("1. COPPER", "Descrizione dei vantaggi del piano Copper...", textColor));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(creaPiano("2. ALLUMINIUM", "Descrizione dei vantaggi del piano Alluminium...", textColor));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(creaPiano("3. GOLD", "Descrizione dei vantaggi del piano Gold...", textColor));

        pagamentoFrame.add(mainPanel);
        pagamentoFrame.setVisible(true);
    }

    static private JPanel creaPiano(String titolo, String descrizione, Color textColor) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(240, 248, 255));

        JLabel titoloLabel = new JLabel(titolo);
        titoloLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titoloLabel.setForeground(textColor);
        titoloLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel descrizioneLabel = new JLabel("<html><p style='width:400px'>" + descrizione + "</p></html>");
        descrizioneLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        descrizioneLabel.setForeground(textColor.darker());
        descrizioneLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(titoloLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(descrizioneLabel);

        return panel;
    }
}
