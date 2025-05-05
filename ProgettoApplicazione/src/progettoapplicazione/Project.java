package progettoapplicazione;

import java.awt.*;
import java.util.*;
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
        
        JTextField codice = new JTextField();
        
        JButton avvia = new JButton("|>");
        avvia.addActionListener(e->{
            compila(codice.getText());
        });
        
        projectFrame.setVisible(true);
    }
    
    //esenpio di codice: Z = a or b;
    private int compila(String testo){
        ArrayList<Variabile> variabiliLocali = new ArrayList<>();
        String[] codice = testo.split(";");
        int risultato = 0;
        for (int i = 0; i < codice.length; i++) {
            if(codice[i].equals("or")){
                codice[i-3].setValue(cercaValore(codice[i - 1], variabiliLocali) + cercaValore(codice[i + 1], variabiliLocali));
            }
            if(codice.equals("a") || codice.equals("b") || codice.equals("c") || codice.equals("d") || codice.equals("e") || codice.equals("f") || codice.equals("g") || codice.equals("h") || codice.equals("i") || codice.equals("j") || codice.equals("k") || codice.equals("l") || codice.equals("m") || codice.equals("n") || codice.equals("o") || codice.equals("p") || codice.equals("q") || codice.equals("r") || codice.equals("s") || codice.equals("t") || codice.equals("u") || codice.equals("v") || codice.equals("w") || codice.equals("x") || codice.equals("y") || codice.equals("z")){
                Variabile a= new Variabile(codice[i],99);
            }
        }
        return risultato > 0 ? 1 : 0;
    }
    
    private int cercaValore(String var, ArrayList<Variabile> lista){
        
    }
}
