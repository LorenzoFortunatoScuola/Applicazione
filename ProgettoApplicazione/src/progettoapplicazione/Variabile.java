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
    public int getValue(){
        return valore;
    }
    public String getNome(){
        return nome;
    }
}
