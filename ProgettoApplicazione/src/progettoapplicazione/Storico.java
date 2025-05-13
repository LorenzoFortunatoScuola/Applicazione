package progettoapplicazione;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Storico {
    
    private JFrame storicoFrame;
    private File[] listaFile = new File[5];
    
    public Storico() throws FileNotFoundException, IOException{
        Storico();
    }
    
    private void Storico() throws FileNotFoundException, IOException{
        storicoFrame = new JFrame("Storico frame");
        storicoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        storicoFrame.setSize(600, 400);
        storicoFrame.setLocationRelativeTo(null);
        
        // Colori principali
        Color backgroundColor = new Color(240, 248, 255);
        Color buttonColor = new Color(100, 149, 237);
        Color textColor = new Color(25, 25, 112);
        
        BufferedReader reader = new BufferedReader(new FileReader(Project.getFile()));
        int numeroRighe = 0;
        String righe = reader.readLine();
        while(righe != null){
            numeroRighe++;
            righe = reader.readLine();
        }
        reader.close();
        int j = 0;
        String text = reader.readLine();
        for (int i = 0; i < 5; j++) {
            if(text.startsWith("(") && text.endsWith(")")){
                JButton a = new JButton(text);
                a.addActionListener(e->{
                    /*try {
                        new Project(text, cercaCodice(text));
                    } catch (IOException ex) {
                        Logger.getLogger(Storico.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                });
                storicoFrame.add(a);
                i++;
            }
            if(j==numeroRighe){
                break;
            }
            text = reader.readLine();
        }
        reader.close();
        
        storicoFrame.setVisible(true);
    }

    private String cercaCodice(String text) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(Project.getFile()));
        String riga = reader.readLine();
        while(riga != null){
            if(riga.equals(text)){
                return reader.readLine();
            }
        }
        return "";
    }
}
