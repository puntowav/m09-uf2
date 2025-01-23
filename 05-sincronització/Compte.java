public class Compte{
    private static Compte compte;
    private float saldo;

    public static Compte getInstance(){
        if (compte == null) compte = new Compte();
        return compte;
    }

    private Compte(){}

    public synchronized float getSaldo(){
        return saldo;
    }

    public synchronized void setSaldo(float saldo){
        this.saldo = saldo;
    }
}