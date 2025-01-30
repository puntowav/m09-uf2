import java.util.Random;

public class Assistent extends Thread{
    private Esdeveniment esdeveniment;
    
    public Assistent(String nom, Esdeveniment esdeveniment){
        super(nom);
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) {            
            if (Math.random() < 0.3) {
                esdeveniment.ferReserva(this);
            }else{
                esdeveniment.eliminaReserva(this);
            }
            try {
                Thread.sleep(r.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
