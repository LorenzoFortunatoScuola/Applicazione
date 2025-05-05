package progettoapplicazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreaFile {
    
    private JFrame creaFileFrame;
    
    public CreaFile(){
        CreaFile();
    }
    
    public String CreaFile(){
        JTextField nomeFileField = new JTextField();
        JButton enter = new JButton("Invia");
        String nomeFile = "error";
        enter.addActionListener(e-> {
            nomeFile = nomeFileField.getText();
        });
        return nomeFile;
    }
}