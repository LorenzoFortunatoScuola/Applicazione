package progettoapplicazione;

import javax.swing.*;

public class Risultato extends JFrame{

    private JLabel risultato;
    
    public Risultato(String compila) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        risultato = new JLabel(compila);
        add(risultato);
    }
    
}
