public class Compte{
    private static Compte compte;
    private float saldo;

    public static Compte getInstance(){
        if (compte == null) compte = new Compte();
        return compte;
    }

    private Compte(){}

    public float getSaldo(){
        return saldo;
    }

    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
}