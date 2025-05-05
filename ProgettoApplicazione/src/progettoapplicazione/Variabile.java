package progettoapplicazione;

public class Variabile {
    
    private String nome;
    private int valore;
    
    public Variabile(String n, int v){
        nome = n;
        valore = v;
    }
    
    public void setValue(int n){
        valore = n;
    }
    public int getValue(int n){
        return valore;
    }
}
