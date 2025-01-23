import java.util.Random;

public class Soci extends Thread {
    private Compte compte;
    private float aportacio = 10f;
    private int esperaMax = 100;
    private Random r;
    private int maxAnys = 10;
    
    public Soci(String nom){
        super(nom);
        compte = Compte.getInstance();
        r = new Random();
    }

    public Compte getCompte(){ return compte;}

    @Override
    public void run(){
        for(int i = 0; i < maxAnys; i++){
            for(int x = 0; x < 12; x++){
                if(i%2 == 0) compte.setSaldo(compte.getSaldo()+aportacio);
                else compte.setSaldo(compte.getSaldo()-aportacio);
                try {
                    Thread.sleep(r.nextInt(esperaMax));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
