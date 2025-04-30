package progettoapplicazione;

import java.awt.*;
import javax.swing.*;

public class Project {
    
    private JFrame projectFrame;
    
    public Project(String nomeFile){
        Project(nomeFile);
    }
    
    private void Project(String nomeFile){
        projectFrame = new JFrame(nomeFile);
        projectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        projectFrame.setSize(600, 400);
        projectFrame.setLocationRelativeTo(null);
        
        // Colori principali
        Color backgroundColor = new Color(240, 248, 255);
        Color buttonColor = new Color(100, 149, 237);
        Color textColor = new Color(25, 25, 112);
        
        JButton exitButton = new JButton("return to home");
        exitButton.addActionListener(e ->{
            projectFrame.dispose();
            new Home();
        });
        
        projectFrame.setVisible(true);
    }
}
