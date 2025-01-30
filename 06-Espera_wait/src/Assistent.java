import java.util.Random;

public class Assistent extends Thread{
    private Esdeveniment esdeveniment;
    
    public Assistent(String nom, Esdeveniment esdeveniment){
        super(nom);
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run() {
        Random r = new Random(1000);
        while (true) {            
            if (Math.random() < 0.5) {
                esdeveniment.ferReserva(this);
            }else{
                esdeveniment.eliminaReserva(this);
            }
            try {
                Thread.sleep(r.nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
