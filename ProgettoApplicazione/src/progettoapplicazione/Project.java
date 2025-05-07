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
    
    //esempio di codice: a = 1; b = 0; Z = a or b;
    private int compila(String testo){
        ArrayList<Variabile> variabiliLocali = new ArrayList<>();
        String[] codice = testo.split(";");
        int risultato = 0;
        for (int i = 0; i < codice.length; i++) {
            if(codice[i].equals("=")){
                if(codice[i+2].equals("or") || codice[i+2].equals("and") || codice[i+2].equals("not")){
                        switch(codice[i+2]){
                            case "or":
                                Variabile a = new Variabile(codice[i - 1], cercaValore(codice[i + 1], variabiliLocali) + cercaValore(codice[i + 3], variabiliLocali));
                        }
                }
            }
        }
        return risultato > 0 ? 1 : 0;
    }
    
    private int cercaValore(String var, ArrayList<Variabile> lista){
        Variabile a = null;
        for (int i = 0; i < lista.size(); i++) {
            if(var.equals(lista.get(i))){
                a = new Variabile(var, lista.get(i).getValue());
            }
        }
        return a.getValue();
    }
    
    private Variabile cercaVariabile(String var, ArrayList<Variabile> lista){
        Variabile a = null;
        for (int i = 0; i < lista.size(); i++) {
            if(var.equals(lista.get(i))){
                a = new Variabile(var, lista.get(i).getValue());
            }
        }
        return a;
    }
}
