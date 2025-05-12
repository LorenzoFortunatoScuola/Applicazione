package progettoapplicazione;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class CreaFile {
    
    private JFrame creaFileFrame = new JFrame();
    static Scanner input = new Scanner(System.in);
    
    public CreaFile(){
        CreaFile();
    }
    
    public void CreaFile(){
        creaFileFrame.setSize(600, 400);
        creaFileFrame.setLocationRelativeTo(null);

        Color backgroundColor = new Color(240, 248, 255);
        Color buttonColor = new Color(100, 149, 237);
        Color textColor = new Color(25, 25, 112);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(150, 40, 150, 40));
        mainPanel.setBackground(backgroundColor);
        
        creaFileFrame.add(mainPanel);
        
        String nomeFile;
        JTextField nomeFileField = new JTextField();
        mainPanel.add(nomeFileField);
        input.next();
        nomeFile = nomeFileField.getText();
        
        JButton creabtn= new JButton("crea");
        mainPanel.add(creabtn);
        creabtn.addActionListener(e->{
            creaFileFrame.dispose();
            try {
                new Project(nomeFile, "");
            } catch (IOException ex) {
                Logger.getLogger(CreaFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        creaFileFrame.setVisible(true);
    }
}