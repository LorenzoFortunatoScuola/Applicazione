package progettoapplicazione;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Project {
    
    private JFrame projectFrame;
    static File progetto;
    
    public Project(String nomeFile) throws IOException{
        Project(nomeFile);
        progetto = new File(nomeFile);
    }
    
    private void Project(String nomeFile) throws IOException{
        projectFrame.setSize(600, 400);
        projectFrame.setLocationRelativeTo(null);

        Color backgroundColor = new Color(240, 248, 255);
        Color buttonColor = new Color(100, 149, 237);
        Color textColor = new Color(25, 25, 112);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(150, 40, 150, 40));
        mainPanel.setBackground(backgroundColor);
        
        projectFrame.add(mainPanel);
        
        JButton exitButton = new JButton("return to home");
        mainPanel.add(exitButton);
        exitButton.addActionListener(e ->{
            projectFrame.dispose();
            new Home();
        });
        
        JTextField codice = new JTextField();
        mainPanel.add(codice);
        
        JButton avvia = new JButton("|>");
        mainPanel.add(avvia);
        avvia.addActionListener(e->{
            new Risultato(compila(codice.getText()));
        });
        
        String testo = codice.getText();
        
        JButton salva = new JButton("Salva");
        mainPanel.add(salva);
        BufferedWriter writer = new BufferedWriter(new FileWriter(progetto));
        salva.addActionListener(e->{
            try {
                writer.write(testo);
            } catch (IOException ex) {
                ex.getMessage();
            }
        });
        
        projectFrame.setVisible(true);
    }
    
    //esempio di codice: a = 1; b = 0; Z = a or b;
    private String compila(String testo){
        ArrayList<Variabile> variabiliLocali = new ArrayList<>();
        String[] codice = testo.split(";");
        int risultato = 0;
        for (int i = 0; i < codice.length; i++) {
            if(codice[i].equals("=")){
                if(codice[i+2].equals("or") || codice[i+2].equals("and") || codice[i+2].equals("not")){
                        switch(codice[i+2]){
                            case "or":
                                Variabile a = new Variabile(codice[i - 1], cercaValore(codice[i + 1], variabiliLocali) + cercaValore(codice[i + 3], variabiliLocali));
                                variabiliLocali.add(a);
                                break;
                            case "and":
                                Variabile b = new Variabile(codice[i - 1], cercaValore(codice[i + 1], variabiliLocali) * cercaValore(codice[i + 3], variabiliLocali));
                                variabiliLocali.add(b);
                                break;
                            case "not":
                                Variabile c = new Variabile(codice[i+1], 0);
                                if(cercaValore(codice[i+1], variabiliLocali) == 0){
                                    c.setValue(1);
                                }
                                variabiliLocali.add(c);
                        }
                }
                if (codice[i+2].equals(";")){
                    if(cercaVariabile(codice[i+2],variabiliLocali)!=null){
                        Variabile a = new Variabile(codice[i-1], cercaValore(codice[i + 1],variabiliLocali));
                    }
                    else{
                        Variabile a = new Variabile(codice[i-1], Integer.parseInt(codice[i + 1]));
                    }
                }
            }
        }
        return risultato > 0 ? "1" : "0";
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
