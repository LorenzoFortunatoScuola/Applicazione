package progettoapplicazione;

import java.awt.*;
import javax.swing.*;

public class Storico {
    
    private JFrame storicoFrame;
    
    public Storico(){
        Storico();
    }
    
    private void Storico(){
        storicoFrame = new JFrame("Storico frame");
        storicoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        storicoFrame.setSize(600, 400);
        storicoFrame.setLocationRelativeTo(null);
        
        // Colori principali
        Color backgroundColor = new Color(240, 248, 255);
        Color buttonColor = new Color(100, 149, 237);
        Color textColor = new Color(25, 25, 112);
        
        storicoFrame.setVisible(true);
    }
}
